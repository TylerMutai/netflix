package com.api.netflix.Controllers;

import com.api.netflix.Models.Movies;
import com.api.netflix.Models.Users;
import com.api.netflix.Repositories.MoviesRepository;
import com.api.netflix.Repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="movies")
public class MoviesController {

    private final MoviesRepository moviesRepository;
    private final UsersRepository usersRepository;

    public MoviesController(MoviesRepository moviesRepository, UsersRepository usersRepository) {
        this.moviesRepository = moviesRepository;
        this.usersRepository = usersRepository;
    }

//    RETRIEVE ALL MOVIES
    @GetMapping
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();

    }
//    RETRIEVE ALL MOVIES BY USER'S NATIONAL ID
    @GetMapping(value = "{nationalId}/movies")
    public List<Movies> findMovieByUserNationalId(@PathVariable Integer nationalId) {
    return moviesRepository.findByUsers_NationalID(nationalId);
    }

//    RETRIEVE A MOVIE BY ITS ID
    @GetMapping(value = "{nationalId}/movies/{id}")
    public List<Movies> findByMovieID(@PathVariable Long id, @PathVariable Integer nationalId) {
        moviesRepository.findByUsers_NationalID(nationalId);
        return moviesRepository.findAllById(id);
    }

//    UPDATE A MOVIES CONTENT
    @PatchMapping(value = "{nationalId}/movies/{id}")
    public Movies movies(@PathVariable Long id, @PathVariable Integer nationalId, @RequestBody Movies movies) {
        moviesRepository.findByUsers_NationalID(nationalId);

        movies.getId(id);
        movies.setMovieName(movies.getMovieName());
        movies.setMovieType(movies.getMovieType());
        movies.setCategories(movies.getCategories());

        return moviesRepository.save(movies);
    }

    //      SEARCH FOR MOVIES BY NAME
    @GetMapping(value = "search")
    public List<Movies> search(@RequestParam String movieName) {
        return moviesRepository.findByMovieName(movieName);
    }
}