package codelab.spring.springboot2.client;


import codelab.spring.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.CacheRequest;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 21);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 21);
        log.info(object);


        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        log.info(Arrays.toString(animes));
        //formatter:off
        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        //formatter: on
        log.info(exchange.getBody());


//        Anime kingdom = Anime.builder().name("Kingdom").build();
////        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes",kingdom, Anime.class);
////        log.info("saved anime {}", kingdomSaved);

        Anime samuraiWarriors = Anime.builder().name("Samurai Warriors").build();
        ResponseEntity<Anime> samuraiWarriorsSaved = new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.POST,
                new HttpEntity<>(samuraiWarriors, createJsonHeader()),
                Anime.class);

        log.info("saved anime {}", samuraiWarriorsSaved);


        Anime animeToBeUpdated = samuraiWarriorsSaved.getBody();
        animeToBeUpdated.setName("Samurai Warriors 2");

        ResponseEntity<Void> samuraiWarriorsUpdated = new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdated ,createJsonHeader()),
                Void.class);
        log.info(samuraiWarriorsUpdated);




        ResponseEntity<Void> samuraiWarriorsDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                animeToBeUpdated.getId());

        log.info(samuraiWarriorsDeleted);

    }
    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
