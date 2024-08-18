package net.talaatharb.movie.service;

import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.talaatharb.movie.dto.MovieDTO;
import net.talaatharb.movie.dto.MoviePageDTO;
import net.talaatharb.movie.dto.MovieSummaryDTO;
import net.talaatharb.movie.mapper.MovieMapper;
import net.talaatharb.movie.model.Movie;
import net.talaatharb.movie.repository.MovieRepository;

@Service
@RequiredArgsConstructor
public class MovieService {

	private static final String API_KEY = "09ad8ace66eec34302943272db0e8d2c";

	private static final String BASE_API = "https://api.themoviedb.org/3";

	private final RestTemplate restTemplate;

	private final MovieMapper movieMapper;

	private final MovieRepository movieRepository;

	public MovieDTO details(Long id) {
		Optional<Movie> movieOptional = movieRepository.findById(id);
		if (movieOptional.isPresent()) {
			return movieMapper.fromEntityToDTO(movieOptional.get());
		}
		MovieDTO movieDTO = fetchMovieDetails(id);
		return saveMovie(movieDTO);
	}

	private MovieDTO fetchMovieDetails(Long id) {
		return restTemplate.getForObject(BASE_API + "/movie/" + id.toString() + "?api_key=" + API_KEY, MovieDTO.class);
	}

	public MoviePageDTO<MovieSummaryDTO> popular(Long page) {
		return restTemplate.exchange(BASE_API + "/movie/popular?api_key=" + API_KEY + "&page=" + page, HttpMethod.GET,
				null, new ParameterizedTypeReference<MoviePageDTO<MovieSummaryDTO>>() {
				}).getBody();
	}

	public MoviePageDTO<MovieSummaryDTO> search(String searchTerm, Long page) {
		return restTemplate.exchange(BASE_API + "/search/movie?api_key=" + API_KEY + "&query=" + searchTerm + "&page=" + page,
				HttpMethod.GET, null, new ParameterizedTypeReference<MoviePageDTO<MovieSummaryDTO>>() {
				}).getBody();
	}

	@Transactional
	public MovieDTO saveMovie(MovieDTO movieDTO) {
		Movie movieEntity = movieMapper.fromDTOToEntity(movieDTO);
		movieRepository.save(movieEntity);
		return movieDTO;
	}

}
