package com.revature.movie.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.movie.models.UserType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTypeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserTypeController controller;

  @Test
  void utControllerContextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  void getAllUserTypesTest() throws Exception {
    this.mockMvc
    .perform(get("/usertypes/usertype")
    .accept(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isOk());
  }

  @Test
  void getUserTypeByIdTest() throws Exception {
    this.mockMvc
    .perform(get("/usertypes/getUserType/39"))
    .andDo(print())
    .andExpect(status().isOk());
  }


  @Test
  void createUserTypeTest() throws Exception {
    this.mockMvc
    .perform(post("/usertypes/addusertype")
    .content(asJsonString(new UserType("Basic")))
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }

  @Test
  void updateUserTypeTest() throws Exception {
    this.mockMvc
    .perform(post("/usertypes/updateusertype/39")
    .content(asJsonString(new UserType("Admin")))
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
