package com.example.discogsrip.controllers;

import com.example.discogsrip.entities.Artist;
import com.example.discogsrip.services.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@RequestMapping("https://localhost8080/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @PostMapping("/artist")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist newArtist){

        return new ResponseEntity<>(artistService.createArtist(newArtist), HttpStatus.CREATED);
    }

}
