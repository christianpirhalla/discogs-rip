package com.example.discogsrip.services;

import com.example.discogsrip.entities.Artist;
import com.example.discogsrip.repositories.ArtistRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArtistServiceTest {

    @Autowired
    ArtistRepository artistRepository = Mockito.mock(ArtistRepository.class);

    ArtistService artistService;
    @BeforeEach
    public void init(){
        artistService = new ArtistService(artistRepository);
    }

    @Test
    @DisplayName("Test Should Pass")
    void updateArtistCountry() {
        Artist mockArtist = Artist.builder().id(123L).artistName("The Wacks").country("Estonia").build();
        Artist updatedMockArtist = Artist.builder().id(123L).artistName("The Wacks").country("USA").build();

        Mockito.when(artistRepository.findById(123L)).thenReturn(Optional.of(mockArtist));

        Artist actualMockArtist = artistService.updateArtistCountry(123L, "USA");

        Assertions.assertThat(actualMockArtist.getCountry()).isEqualTo(updatedMockArtist.getCountry());
    }

    @Test
    @DisplayName("M")
    void createArtistTest() {
        Artist mockArtist = Artist.builder().id(123L).artistName("The Wacks").country("Estonia").build();

        Mockito.when(artistRepository.save(mockArtist)).thenReturn(mockArtist);

        Artist actualMockArtist = artistService.createArtist(mockArtist);

        Assertions.assertThat(actualMockArtist).isEqualTo(mockArtist);
    }
}