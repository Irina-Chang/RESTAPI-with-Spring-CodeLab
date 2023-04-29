package codelab.spring.springboot2.repository;

import codelab.spring.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime , Long> {
    List<Anime> findAllBy();
}
