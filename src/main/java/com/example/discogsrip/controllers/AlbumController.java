package com.example.discogsrip.controllers;

import com.example.discogsrip.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {

    @Autowired
    AlbumService albumService;

}
