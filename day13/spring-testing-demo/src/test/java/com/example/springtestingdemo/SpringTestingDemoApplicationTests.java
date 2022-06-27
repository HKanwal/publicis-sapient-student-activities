package com.example.springtestingdemo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = Restapi.class)
class SpringTestingDemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	MyService myService;

	@Test
	public void testGreetings() throws Exception {
		when(myService.welcome("Hark")).thenReturn("Welcome Hark");
		mvc.perform(get("/api/Hark")).andExpect(content().string("WELCOME HARK"));
	}

}
