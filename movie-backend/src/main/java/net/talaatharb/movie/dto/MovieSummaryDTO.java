package net.talaatharb.movie.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class MovieSummaryDTO {
	private boolean adult;

	@JsonAlias("backdrop_path")
	private String backdropPath;
	
	@JsonAlias({"genre_ids", "genres"})
	private List<Long> genreIds = new ArrayList<>();
		
	private Long id;

	@JsonAlias("origin_country")
	private List<String> originCountry = new ArrayList<>();

	@JsonAlias("original_language")
	private String originalLanguage;

	@JsonAlias("original_title")
	private String originalTitle;

	private String overview;
	
	private Double popularity;

	@JsonAlias("poster_path")
	private String posterPath;
	
	@JsonAlias("release_date")
	private String releaseDate;
	
	private String title;
	
	private boolean video;
	
	@JsonAlias("vote_average")
	private Double voteAverage;
	
	@JsonAlias("vote_count")
	private Long voteCount;
}
