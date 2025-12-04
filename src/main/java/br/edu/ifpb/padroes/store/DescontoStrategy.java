package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;

public interface DescontoStrategy {

    double aplicar(Album album, CustomerType customerType);
}
