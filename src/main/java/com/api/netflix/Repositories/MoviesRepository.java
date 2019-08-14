package com.api.netflix.Repositories;

import com.api.netflix.Models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {

    List<Movies> findByUsers_NationalID(Integer id);
    List<Movies> findByMovieNameStartingWith(String movieName);
    List<Movies> findByMovieName(String movieName);
    List<Movies> findAllById(Long id);
}
