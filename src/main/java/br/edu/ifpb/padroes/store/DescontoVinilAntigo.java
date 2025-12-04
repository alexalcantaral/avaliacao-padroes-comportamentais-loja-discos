package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;
import br.edu.ifpb.padroes.music.MediaType;

public class DescontoVinilAntigo implements DescontoStrategy{
    @Override
    public double aplicar(Album album, CustomerType customerType) {
        if(album.getType().equals(MediaType.VINYL) && album.getReleaseDate().getYear() < 1980){
            return album.getPrice() * 0.10;
        }
        return 0;
    }
}
