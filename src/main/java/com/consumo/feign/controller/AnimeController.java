package com.consumo.feign.controller;

import com.consumo.feign.domain.Anime;
import com.consumo.feign.feign.client.AnimeClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@NoArgsConstructor
@RequestMapping
@RestController
public class AnimeController {

    @Autowired
    private AnimeClient animeClient;

    @GetMapping("anime/{id}")
    public Anime getById(@PathVariable long id){
        return this.animeClient.getById(id);
    }

    @PostMapping("/animes")
    public Anime save(@RequestBody Anime anime){
        anime.setId(null);
        Anime animeSalvo = animeClient.save(anime);
        System.out.println(animeSalvo);
        return animeSalvo;
    }

}
