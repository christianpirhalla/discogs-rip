package com.example.discogsrip.controllers;

import com.example.discogsrip.DiscogsRipApplication;
import com.example.discogsrip.entities.Artist;
import com.example.discogsrip.services.ArtistService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = ArtistController.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DiscogsRipApplication.class)
class ArtistControllerTest {

    @MockBean
    private ArtistService artistService;

    //@MockBean Person

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSaveArtist() throws Exception{

        Artist mockArtist = Artist.builder().id(123L).artistName("The Wacks").country("Estonia").build();

        Mockito.when(artistService.createArtist(mockArtist)).thenReturn(mockArtist);

        mockMvc.perform(MockMvcRequestBuilders.post("/artist", mockArtist)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content("insert JSON string here"))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.is(123)));
    }

}