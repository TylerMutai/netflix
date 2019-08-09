package com.api.netflix.Repositories;

import com.api.netflix.Models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface moviesRepository extends JpaRepository<Movies, Long> {
}
