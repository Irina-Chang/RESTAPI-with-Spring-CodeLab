package codelab.spring.springboot2.repository;

import codelab.spring.springboot2.domain.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime , Long> {
    List<Anime> findByName(String name);

}
