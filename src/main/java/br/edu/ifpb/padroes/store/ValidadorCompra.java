package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.music.Album;

public interface ValidadorCompra {

    boolean validar(Customer customer, Album album);
    void setProximo(ValidadorCompra proximo);
}
