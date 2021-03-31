package com.revature.movie.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.movie.models.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserController uController;

  @Test
  void contextLoads() {
    assertThat(uController).isNotNull();
  }

  @Test
  void getUsersTest() throws Exception {
    this.mockMvc
    .perform(get("/movieusers/users")
    .accept(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isOk());
  }

  @Test
  void getUserByIdTest() throws Exception {
    this.mockMvc
    .perform(get("/movieusers/getuser/53"))
    .andDo(print())
    .andExpect(status().isOk());
  }


  @Test
  void createUserTest() throws Exception {
    this.mockMvc
    .perform(post("/movieusers/adduser")
    .content(asJsonString(new User("bat", "villain", "L", "h", null)))
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }

  @Test
  void updateUserTest() throws Exception {
    this.mockMvc
    .perform(post("/movieusers/updateuser/53")
    .content(asJsonString(new User("rat", "hero", "L", "h", null)))
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
