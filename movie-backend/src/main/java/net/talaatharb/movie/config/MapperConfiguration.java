package net.talaatharb.movie.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.talaatharb.movie.mapper.MovieMapper;

@Configuration
public class MapperConfiguration {

	@Bean
	MovieMapper movieMapper() {
		return Mappers.getMapper(MovieMapper.class);
	}
}
