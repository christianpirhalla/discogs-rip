package com.example.discogsrip.controllers;

import com.example.discogsrip.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {

    @Autowired
    ArtistService artistService;


}
