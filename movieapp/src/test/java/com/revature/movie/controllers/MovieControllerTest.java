package com.revature.movie.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.movie.models.Movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MovieController controller;

  @Test
  void movieControllerContextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  void getAllMovieTest() throws Exception {
    this.mockMvc
    .perform(get("/movie/movies")
    .accept(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isOk());
  }

  @Test
  void getMovieByIdTest() throws Exception {
    this.mockMvc
    .perform(get("movie/moviebyid/1"))
    .andDo(print())
    .andExpect(status().isOk());
  }


  @Test
  void createMovieTest() throws Exception {
    this.mockMvc
    .perform(post("movie/addmovie")
    .content(asJsonString(new Movie("Avengers 2")))
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }

  @Test
  void updateMovieTest() throws Exception {
    this.mockMvc
    .perform(post("/movie/updatemovie/1")
    .content(asJsonString(new Movie("Avengers")))
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }

  // @Test
  // void loginTest() throws Exception {
  //   this.mockMvc
  //   .perform(get("/movieusers/login/Cyber/hero")
  //   .contentType(MediaType.APPLICATION_JSON))
  //   .andExpect(status().isOk());
  // }


  public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

  }
  
}
