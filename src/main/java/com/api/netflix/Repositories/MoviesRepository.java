package com.api.netflix.Repositories;

import com.api.netflix.Models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {

    List<Movies> findAllByMovieTypeIs(String type);

    Movies findByMovieId(long id);

//    List<Movies> findAll();
}
