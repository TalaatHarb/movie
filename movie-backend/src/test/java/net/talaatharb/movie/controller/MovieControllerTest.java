package net.talaatharb.movie.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.movie.service.MovieService;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

	@InjectMocks
	private MovieController movieController;

	@Mock
	private MovieService movieServie;

	@Test
	void testDetails() {
		// Given (Arrange)
		long id = 1L;

		// When (Act)
		movieController.details(id);

		// Then (Assert)
		verify(movieServie).details(id);
	}

	@Test
	void testPopular() {
		// Given (Arrange)
		long page = 1L;

		// When (Act)
		movieController.popular(page);

		// Then (Assert)
		verify(movieServie).popular(page);
	}

	@Test
	void testSearch() {
		// Given (Arrange)
		String searchTerm = "Snow";
		long page = 1L;

		// When (Act)
		movieController.search(searchTerm, page);

		// Then (Assert)
		verify(movieServie).search(searchTerm, page);

	}

}
