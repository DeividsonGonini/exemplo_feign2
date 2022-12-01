package com.consumo.feign.feign.client;

import com.consumo.feign.config.Authorization;
import com.consumo.feign.domain.Anime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "anime", url = "http://localhost:8081",
        configuration = Authorization.class)
public interface AnimeClient {

    @PostMapping(value = "/animes",
            consumes = "application/json",
            produces = "application/json")
    Anime save(@RequestBody Anime anime);

    @GetMapping(value = "animes/by-id/{idAnime}")
    Anime getById(@PathVariable long idAnime);
}
