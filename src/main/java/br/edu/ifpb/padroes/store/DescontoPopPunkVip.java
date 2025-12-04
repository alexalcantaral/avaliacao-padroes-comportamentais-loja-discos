package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;

public class DescontoPopPunkVip implements DescontoStrategy{

    @Override
    public double aplicar(Album album, CustomerType tipoCliente){
        if(album.getGenre().equalsIgnoreCase("Pop Punk") && tipoCliente.equals(CustomerType.VIP)){
            return album.getPrice() * 0.05;
        }
        return 0;
    }
}
