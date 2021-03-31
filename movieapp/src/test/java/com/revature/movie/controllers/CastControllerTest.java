package com.revature.movie.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.movie.models.Cast;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CastControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private CastController controller;

  @Test
  void castControllerContextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  void getCastTest() throws Exception {
    this.mockMvc
    .perform(get("/castmembers/allcast")
    .accept(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isOk());
  }

  @Test
  void getCastByIdTest() throws Exception {
    this.mockMvc
    .perform(get("/castmembers/getcast/3"))
    .andDo(print())
    .andExpect(status().isOk());
  }


  @Test
  void createCastTest() throws Exception {
    this.mockMvc
    .perform(post("/castmembers/addcast")
    .content(asJsonString(new Cast("Tyson Mike", "Supporting")))
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }

  @Test
  void updateCastTest() throws Exception {
    this.mockMvc
    .perform(post("/castmembers/updatecast/3")
    .content(asJsonString(new Cast("Mike Tyson", "Lead")))
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
