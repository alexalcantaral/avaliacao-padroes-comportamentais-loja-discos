package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.music.Album;

public class TypeSearchStrategy implements SearchStrategy{

    @Override
    public boolean matches(Album album, String searchTerm) {
        return album.getType().name().equalsIgnoreCase(searchTerm);
    }
}
