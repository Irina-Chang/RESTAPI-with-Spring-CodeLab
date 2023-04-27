package codelab.spring.springboot2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;

    //@JsonProperty("name")
    //    private String nameCharacter;


}