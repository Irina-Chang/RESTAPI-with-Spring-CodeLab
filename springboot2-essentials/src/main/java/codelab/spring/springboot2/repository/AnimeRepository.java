package codelab.spring.springboot2.repository;

import codelab.spring.springboot2.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
