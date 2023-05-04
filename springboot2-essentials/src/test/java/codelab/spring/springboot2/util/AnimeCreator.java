package codelab.spring.springboot2.util;

import codelab.spring.springboot2.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved(){
        return Anime.builder()
                .name("Denkigai no Honya-san")
                .build();
    }
    public static Anime createValidAnime(){
        return Anime.builder()
                .name("Denkigai no Honya-san")
                .id(1L)
                .build();
    }
    public static Anime createValidUpdateAnime(){
        return Anime.builder()
                .name("Denkigai no Honya-san 2")
                .id(1L)
                .build();
    }
}
