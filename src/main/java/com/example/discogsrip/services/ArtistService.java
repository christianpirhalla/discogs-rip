package com.example.discogsrip.services;

import com.example.discogsrip.entities.Artist;
import com.example.discogsrip.repositories.ArtistRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public Artist updateArtistCountry(Long id, String newCountry){
        log.info("updateArtistCountry called");
        Artist updatedArtist = artistRepository.findById(id).get();
        updatedArtist.setCountry(newCountry);
        artistRepository.save(updatedArtist);
        return updatedArtist;
    }

}
