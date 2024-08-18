package net.talaatharb.movie.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.talaatharb.movie.dto.MovieDTO;
import net.talaatharb.movie.mapper.MovieMapper;
import net.talaatharb.movie.model.Movie;
import net.talaatharb.movie.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

	@InjectMocks
	private MovieService movieService;

	@Mock
	private MovieMapper movieMapper;

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private RestTemplate restTemplate;

	@Test
	void testDetailsWithoutDatabaseHit() {
		// Given
		MovieDTO movieDTO = new MovieDTO();
		Movie movie = new Movie();
		when(movieRepository.findById(anyLong())).thenReturn(Optional.empty());
		when(restTemplate.getForObject(anyString(), any(Class.class))).thenReturn(movieDTO);
		when(movieMapper.fromDTOToEntity(any(MovieDTO.class))).thenReturn(movie);

		// When
		movieService.details(1L);

		// Then
		verify(restTemplate).getForObject(anyString(), any(Class.class));
		verify(movieRepository).save(any(Movie.class));
	}

	@Test
	void testDetailsWithDataBaseHit() {
		// Given
		Movie movie = new Movie();
		when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

		// When
		movieService.details(1L);

		// Then
		verify(movieMapper).fromEntityToDTO(movie);
	}

	@Test
	void testPopular() {
		long page = 1L;
		when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class)))
				.thenReturn(ResponseEntity.of(Optional.empty()));

		movieService.popular(page);

		verify(restTemplate).exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class));
	}

	@Test
	void testSearch() {
		long page = 1L;
		String searchTerm = "Search";
		when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class)))
				.thenReturn(ResponseEntity.of(Optional.empty()));

		movieService.search(searchTerm, page);

		verify(restTemplate).exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class));
	}

}
