package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.music.Album;

public class ArtistSearchStrategy implements SearchStrategy {

    @Override
    public boolean matches(Album album, String searchTerm) {
        return album.getArtist().toLowerCase().contains(searchTerm.toLowerCase());
    }
}
