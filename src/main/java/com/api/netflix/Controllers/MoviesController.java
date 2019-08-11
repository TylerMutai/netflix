package com.api.netflix.Controllers;


import com.api.netflix.Models.Movies;
import com.api.netflix.Repositories.moviesRepository;
import com.api.netflix.Repositories.userRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="movies")
public class moviesController {

    private final moviesRepository moviesRepository;
    private final userRepository userRepository;


    public moviesController(moviesRepository moviesRepository, userRepository userRepository) {
        this.moviesRepository = moviesRepository;
        this.userRepository = userRepository;

    }

    //retrieve and display all the movies
    @GetMapping
    public List<Movies> pullMovies() {
        return moviesRepository.findAll();

    }

    @GetMapping(value = "{id}")
    public Movies findBymovieID(@PathVariable Long id) {

        Movies movies
                = null;
        try {
            movies = moviesRepository.findById(id).orElseThrow(
                    () -> new NotFoundException("no movie with the id" + id + "was found"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        movies.setMovieId(movies.getMovieId());
        movies.setMovieName(movies.getMovieName());
        movies.setMovieGenre(movies.getMovieGenre());

        return movies;


    }
}

   /* @PostMapping(value = "{id}/addmovie")
    public Users addnew( @PathVariable Long id, @RequestBody Movies movies) {

        Movies addnew =moviesRepository.findByMovieId(id);
        Categories categories=categoryRepository.getOne(id);

        addnew.setMovieName(addnew.getMovieName());
        addnew.setMovieGenre(addnew.getMovieGenre());
        categories.setCategoryId(categories.getCategoryId());
        addnew.setMovieType(addnew.getMovieType());

        return moviesRepository.save(addnew);


    }

}*/