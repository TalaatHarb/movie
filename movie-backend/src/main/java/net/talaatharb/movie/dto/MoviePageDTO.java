package net.talaatharb.movie.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class MoviePageDTO<T> {

	private Long page;
	
	private List<T> results = new ArrayList<>();
	
	@JsonAlias("total_pages")
	private Long totalPages;
	
	@JsonAlias("total_results")
	private Long totalResults;
}
