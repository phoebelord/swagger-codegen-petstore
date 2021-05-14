package com.phoebelord.oapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class PetControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void Should_returnCreated_When_givenValidPet() throws Exception {
    InputStream stream = new ClassPathResource("pet.json").getInputStream();
    String petJSON = new String(stream.readAllBytes());

    mockMvc.perform(post("/pet").contentType("application/json").content(petJSON)).andExpect(status().isCreated());
  }

  @Test
  // TODO: this will fail unless you edit generated Dog and Cat to extend Animal!
  public void Should_returnBadRequest_When_givenInvalidPet() throws Exception {
    InputStream stream = new ClassPathResource("invalidPet.json").getInputStream();
    String invalidPetJSON = new String(stream.readAllBytes());

    mockMvc.perform(post("/pet").contentType("application/json").content(invalidPetJSON))
        .andExpect(status().isBadRequest());
  }
}
