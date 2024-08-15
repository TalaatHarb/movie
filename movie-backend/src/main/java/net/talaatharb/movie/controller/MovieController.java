package net.talaatharb.movie.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.movie.dto.MovieDTO;
import net.talaatharb.movie.dto.MoviePageDTO;
import net.talaatharb.movie.dto.MovieSummaryDTO;
import net.talaatharb.movie.service.MovieService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class MovieController {
	
	private final MovieService movieServie;
	
	@GetMapping("/movie/{id}")
	MovieDTO details(@PathVariable Long id) {
		log.debug("Fetching movie with id: {}", id);
		return movieServie.details(id);
	}
	
	@GetMapping("/movie/popular")
	MoviePageDTO<MovieSummaryDTO> popular(@RequestParam(defaultValue = "1") Long page) {
		log.debug("Fetching popular movies, page = {}", page);
		return movieServie.popular(page);
	}
	
	@GetMapping("/search/movie")
	MoviePageDTO<MovieSummaryDTO> search(@RequestParam String searchTerm, @RequestParam(defaultValue = "1") Long page) {
		log.debug("Fetching search results for search term '{}' and page = {}", searchTerm, page);
		return movieServie.search(searchTerm, page);
	}

}
