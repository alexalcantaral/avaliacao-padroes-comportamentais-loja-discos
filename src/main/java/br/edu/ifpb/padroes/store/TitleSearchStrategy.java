package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.music.Album;

public class TitleSearchStrategy implements SearchStrategy{

    @Override
    public boolean matches(Album album, String searchTerm) {
        return album.getTitle().toLowerCase().contains(searchTerm.toLowerCase());
    }
}
