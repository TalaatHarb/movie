package net.talaatharb.movie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Movie {
	private boolean adult;

	private String backdropPath;
	
	private Double budget;
		
	private String homepage;
	
	@Id
	private Long id;

	private String imdbId;

	private String originalLanguage;

	private String originalTitle;

	@Column(length = 1023)
	private String overview;
	
	private Double popularity;

	private String posterPath;
			
	private String releaseDate;
	
	private Long revenue;
	
	private Long runtime;
		
	private String status;
	
	private String tagline;
	
	private String title;
	
	private boolean video;
	
	private Double voteAverage;
	
	private Long voteCount;

}
