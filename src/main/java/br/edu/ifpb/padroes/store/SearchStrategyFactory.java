package br.edu.ifpb.padroes.store;

public class SearchStrategyFactory {

    public static SearchStrategy getStrategy(SearchType type){
        switch(type){
            case TITLE:
                return new TitleSearchStrategy();
            case ARTIST:
                return new ArtistSearchStrategy();
            case GENRE:
                return new GenreSearchStrategy();
            case TYPE:
                return new TypeSearchStrategy();
            default:
                throw new IllegalArgumentException("SearchType inválido");
        }
    }
}
