package net.talaatharb.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.talaatharb.movie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
