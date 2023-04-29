package codelab.spring.springboot2.service;

import codelab.spring.springboot2.domain.Anime;
import codelab.spring.springboot2.exception.BadRequestException;
import codelab.spring.springboot2.mapper.AnimeMapper;
import codelab.spring.springboot2.repository.AnimeRepository;
import codelab.spring.springboot2.requests.AnimePostRequestBody;
import codelab.spring.springboot2.requests.AnimePutRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable){return animeRepository.findAll(pageable);}
    public List<Anime> findByName(String name){return animeRepository.findByName(name);}

    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                    .orElseThrow(() -> new BadRequestException("Anime ID not Found"));


    }
    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save (AnimeMapper.INSTANCE.toAnime(animePostRequestBody));

    }

    public void delete(Long id) {
                animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
       Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
       Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
       anime.setId(savedAnime.getId());
       animeRepository.save(anime);

    }



}
