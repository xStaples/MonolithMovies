package com.revature.movie;

import com.revature.movie.controllers.UserController;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieappApplicationTests {

	@Autowired
  private UserController uController;

	@Test
	void contextLoads() {
		assertThat(uController).isNotNull();
	}

}
