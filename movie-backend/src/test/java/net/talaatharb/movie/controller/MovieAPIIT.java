package net.talaatharb.movie.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@Tag("integration")
class MovieAPIIT {
	
	@Autowired
	protected MockMvc mvc;

	@Autowired
	protected ObjectMapper objectMapper;
	
	@Test
	void testPopular() throws Exception {
		var result = mvc.perform(get("/movie/popular"));
		
		result.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void testDetails() throws Exception {
		var result = mvc.perform(get("/movie/11"));
		
		result.andExpect(status().is2xxSuccessful());
	}

}
