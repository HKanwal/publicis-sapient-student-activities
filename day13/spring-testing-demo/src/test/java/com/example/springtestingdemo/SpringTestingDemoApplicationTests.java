package com.example.springtestingdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = Restapi.class)
class SpringTestingDemoApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGreetings() throws Exception {
		mvc.perform(get("/api/Sachin")).andExpect(content().string("Welcome Sachin"));
	}

}
