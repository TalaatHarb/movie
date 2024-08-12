package net.talaatharb.movie.mapper;

import org.mapstruct.Mapper;

import net.talaatharb.movie.dto.MovieDTO;
import net.talaatharb.movie.model.Movie;

@Mapper
public interface MovieMapper {

	Movie fromDTOToEntity(MovieDTO movieDTO);
	
	MovieDTO fromEntityToDTO(Movie movie);
}
