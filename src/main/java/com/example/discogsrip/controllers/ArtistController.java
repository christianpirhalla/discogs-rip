package com.example.discogsrip.controllers;

import com.example.discogsrip.entities.Artist;
import com.example.discogsrip.services.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @PostMapping()
    public ResponseEntity<Artist> createArtist(@RequestBody Artist newArtist){

        return new ResponseEntity<>(artistService.createArtist(newArtist), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable("id") Long id){

        return new ResponseEntity<>(artistService.deleteArtist(id), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtist(@PathVariable("id") Long id){

        return new ResponseEntity<>(artistService.getArtist(id), HttpStatus.OK);
    }

}
