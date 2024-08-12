package net.talaatharb.movie.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class MovieDTO {
	private boolean adult;

	@JsonAlias("backdrop_path")
	private String backdropPath;
	
	private Double budget;
		
	private String homepage;
	
	private Long id;

	@JsonAlias("imdb_id")
	private String imdbId;

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
	
	private Long revenue;
	
	private Long runtime;
	
	private String status;
	
	private String tagline;
	
	private String title;
	
	private boolean video;
	
	@JsonAlias("vote_average")
	private Double voteAverage;
	
	@JsonAlias("vote_count")
	private Long voteCount;
}
