package com.api.netflix.Controllers;


import com.api.netflix.Models.Movies;
import com.api.netflix.Repositories.MoviesRepository;
import com.api.netflix.Repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="movies")
public class moviesController {

    private final MoviesRepository moviesrepository;
    private final UserRepository userepository;

    public moviesController(MoviesRepository moviesrepository, UserRepository userepository) {
        this.moviesrepository = moviesrepository;
        this.userepository = userepository;
    }

    //retrieve and display all the movies
    @GetMapping
    public List<Movies> pullMovies() {
        return moviesrepository.findAll();

    }

    @GetMapping(value = "{id}")
    public Movies findBymoviesID(@PathVariable Long id) {

        Movies movies
                = null;
        try {
            movies = moviesrepository.findById(id).orElseThrow(
                    () -> new NotFoundException("no movie with the id" + id + "was found"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        movies.setMovieId(movies.getMovieId());
        movies.setMovieName(movies.getMovieName());
//        movies.setMovieGenre(movies.getMovieGenre());
gst
        return movies;
    }

    @PostMapping(value = "{id}/addmovie")
    public Movies addnew( @PathVariable Long id, @RequestBody Movies movies) {
        Movies addnew = moviesrepository.findByMovieId(id);

        addnew.setMovieName(addnew.getMovieName());
        return addnew;
    }
}
