package com.example.springboot2essentials.controller;

import com.example.springboot2essentials.domain.Anime;
import com.example.springboot2essentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor //essa annotation elimina escrever o construtor dentro da classe
public class AnimeController {

//@Autowired ->faz um injeção de dependencia, mas não é correto deixar ele neste local
    private DateUtil dateUtil;

  /*  public AnimeController(DateUtil dateUtil) {//utilizando esse construtor, é feito uma injeçao de dependencia
        this.dateUtil = dateUtil;
    }
    A maneira correta de criar uma injeçao de dependencia é utilizando uma interface*/

    @GetMapping("list")
    public List<Anime> list(){

        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DB2"), new Anime("Berserk"));}
}

