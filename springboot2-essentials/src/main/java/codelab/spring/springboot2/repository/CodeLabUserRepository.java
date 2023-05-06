package codelab.spring.springboot2.repository;

import codelab.spring.springboot2.domain.Anime;
import codelab.spring.springboot2.domain.CodeLabUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeLabUserRepository extends JpaRepository<CodeLabUserRepository , Long> {
    CodeLabUser findByUsername(String username);

}
