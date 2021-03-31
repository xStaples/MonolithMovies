package com.revature.movie.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.movie.models.Details;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class DetailsControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private DetailsController controller;

  @Test
  void detailsControllerContextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  void getAllDetailsTest() throws Exception {
    this.mockMvc
    .perform(get("/moviedetails/details")
    .accept(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isOk());
  }

  @Test
  void getDetailsByIdTest() throws Exception {
    this.mockMvc
    .perform(get("/moviedetails/getdetails/2"))
    .andDo(print())
    .andExpect(status().isOk());
  }


  @Test
  void createDetailsTest() throws Exception {
    this.mockMvc
    .perform(post("/moviedetails/adddetails")
    .content(asJsonString(new Details("Action", "Snoop Lion")))
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }

  @Test
  void updateDetailsTest() throws Exception {
    this.mockMvc
    .perform(post("/moviedetails/updatedetails/2")
    .content(asJsonString(new Details("Action", "Snoop Dogg")))
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
