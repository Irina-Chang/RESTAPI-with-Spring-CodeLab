package codelab.spring.springboot2.util;

import codelab.spring.springboot2.domain.Anime;
import codelab.spring.springboot2.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {
    public static AnimePostRequestBody createAnimePostRequestBody(){
        return AnimePostRequestBody.builder()
                .name(AnimeCreator.createAnimeToBeSaved().getName())
                .build();
    }
}
