package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.AgeRestriction;
import br.edu.ifpb.padroes.music.Album;
import br.edu.ifpb.padroes.music.MediaType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MusicStore {

    private List<Album> inventory = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    private ValidadorCompra cadeiaValidador;

    private final List<DescontoStrategy> estrategiasDesconto = List.of(
            new DescontoTipoCliente(),
            new DescontoVinilAntigo(),
            new DescontoPopPunkVip()
    );


    public MusicStore() {
        ValidadorEstoque validadorEstoque = new ValidadorEstoque();
        ValidadorCredito validadorCredito = new ValidadorCredito();
        ValidadorIdade validadorIdade = new ValidadorIdade();

        validadorEstoque.setProximo(validadorCredito);
        validadorCredito.setProximo(validadorIdade);

        this.cadeiaValidador = validadorEstoque;
    }

    public void addMusic(Album album) {
        inventory.add(album);
        System.out.println("Added: " + album.getTitle());
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Album> searchMusic(SearchType searchType, String searchTerm) {
        SearchStrategy strategy = SearchStrategyFactory.getStrategy(searchType);

        List<Album> results = new ArrayList<>();

        for(Album album : inventory){
            if(strategy.matches(album, searchTerm)){
                results.add(album);
            }
        }

        return results;
    }

    public double calculateDiscount(Album album, CustomerType customerType) {
        double descontoTotal = 0;

        for(DescontoStrategy strategy : estrategiasDesconto){
            descontoTotal += strategy.aplicar(album, customerType);
        }
        return descontoTotal;
    }

    public void purchaseMusic(Customer customer, Album album) {
        if (validatePurchase(customer, album)) {
            double discount = calculateDiscount(album, customer.getType());
            double finalPrice = album.getPrice() - discount;

            System.out.println("Purchase: " + album.getFormattedName() + " by " + customer.getName());
            System.out.println("Original price: $" + album.getPrice());
            System.out.println("Discount: $" + discount);
            System.out.println("Final price: $" + finalPrice);

            album.decreaseStock();
            customer.addPurchase(album);

            for (Customer c : customers) {
                if (c.isInterestedIn(album.getGenre()) && !c.equals(customer)) {
                    System.out.println("Notifying " + c.getName() + " about popular " + album.getGenre() + " purchase");
                }
            }
        } else {
            System.out.println("Out of stock!");
        }
    }

    public boolean validatePurchase(Customer customer, Album album) {
        return cadeiaValidador.validar(customer, album);
    }

    public List<Album> getInventory() {
        return inventory;
    }

}
