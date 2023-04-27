package codelab.spring.springboot2.service;

import codelab.spring.springboot2.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    public List<Anime> listAll(){
        return List.of(new Anime(1L,"DB2"), new Anime(2L,"Berserk"));
    }
}
