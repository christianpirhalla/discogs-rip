package com.example.discogsrip.controllers;

import com.example.discogsrip.services.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AlbumController {

    @Autowired
    AlbumService albumService;


}
