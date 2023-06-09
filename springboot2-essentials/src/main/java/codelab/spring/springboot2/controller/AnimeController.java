package codelab.spring.springboot2.controller;


import codelab.spring.springboot2.domain.Anime;
import codelab.spring.springboot2.requests.AnimePostRequestBody;
import codelab.spring.springboot2.requests.AnimePutRequestBody;
import codelab.spring.springboot2.service.AnimeService;
import codelab.spring.springboot2.util.DateUtil;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
@ResponseStatus
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<Page<Anime>>list(Pageable pageable) {

        //return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK) ;
        return ResponseEntity.ok(animeService.listAll(pageable));
    }
    @GetMapping( "/all")
    public ResponseEntity<List<Anime>>listAll() {

        return ResponseEntity.ok(animeService.listAllNonPageable());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        //return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK) ;
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));

    }
    @GetMapping("by-id/{id}")
    public ResponseEntity<Anime> findByIdAuthenticationPrincipal(@PathVariable Long id,
                                                                 @AuthenticationPrincipal UserDetails userDetails) {
        log.info(userDetails);
        //return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK) ;
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));

    }
    @GetMapping("/find")
    public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(animeService.findByName(name));}

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody animePostRequestBody) {
    return new ResponseEntity<>(animeService.save(animePostRequestBody),HttpStatus.CREATED );
    }

    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){
      animeService.replace(animePutRequestBody);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
