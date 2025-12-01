package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.music.Album;

public interface SearchStrategy {

    boolean matches(Album album, String searchTerm);
}
