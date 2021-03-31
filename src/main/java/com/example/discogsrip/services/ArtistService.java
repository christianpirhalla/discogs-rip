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

    public Artist createArtist(Artist newArtist) {
        log.info("createArtist called");
        return artistRepository.save(newArtist);
    }

    public Boolean deleteArtist(Long id) {
        log.info("deleteArtist called");
        try {
            artistRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.info("Error deleting: " + e.toString());
            return false;
        }
    }

    public Artist getArtist(Long id) {
        log.info("getArtist called");
        try {
            return artistRepository.findById(id).get();
        } catch (Exception e) {
            log.info("Error getting: " + e.toString());
            return null;
        }
    }

}
