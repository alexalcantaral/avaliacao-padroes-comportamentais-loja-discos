package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.music.Album;

public class ValidadorEstoque implements ValidadorCompra{

    private ValidadorCompra proximo;

    @Override
    public boolean validar(Customer customer, Album album) {
        if(album.getStock() <= 0){
            System.out.println("Falha na validação: Álbum sem estoque.");
            return false;
        }

        return proximo == null || proximo.validar(customer, album);
    }

    @Override
    public void setProximo(ValidadorCompra proximo) {
        this.proximo = proximo;
    }
}
