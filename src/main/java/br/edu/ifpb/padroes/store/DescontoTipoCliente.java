package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;

public class DescontoTipoCliente implements DescontoStrategy {

    @Override
    public double aplicar(Album album, CustomerType customerType) {
        return switch(customerType){
            case VIP -> album.getPrice() * 0.20;
            case PREMIUM -> album.getPrice() * 0.15;
            case REGULAR -> album.getPrice() * 0.05;
            default -> 0;
        };
    }
}
