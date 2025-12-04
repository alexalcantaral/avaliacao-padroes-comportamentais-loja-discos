package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.music.AgeRestriction;
import br.edu.ifpb.padroes.music.Album;

import java.time.LocalDate;

public class ValidadorIdade implements ValidadorCompra{

    private ValidadorCompra proximo;

    @Override
    public boolean validar(Customer customer, Album album) {

        boolean ehConteudoExplicito = album.getAgeRestriction().equals(AgeRestriction.PARENTAL_ADVISORY);
        boolean ehMenorDe18 = customer.getDateOfBirth().isAfter(LocalDate.now().minusYears(18));

        if (ehConteudoExplicito && ehMenorDe18) {
            System.out.println("Falha na validação: Cliente não tem idade para esse conteúdo.");
            return false;
        }

        return proximo == null || proximo.validar(customer, album);
    }

    @Override
    public void setProximo(ValidadorCompra proximo) {
        this.proximo = proximo;
    }
}
