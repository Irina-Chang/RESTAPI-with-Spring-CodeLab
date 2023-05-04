package codelab.spring.springboot2.util;

import codelab.spring.springboot2.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody(){
        return AnimePutRequestBody.builder()
                .id(AnimeCreator.createValidAnime().getId())
                .name(AnimeCreator.createValidUpdateAnime().getName())
                .build();
    }
}
