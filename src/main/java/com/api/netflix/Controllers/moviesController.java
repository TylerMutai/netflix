package com.api.netflix.Controllers;


import com.api.netflix.Models.Users;
import com.api.netflix.Models.Categories;
import com.api.netflix.Models.Movies;
import com.api.netflix.Repositories.moviesRepository;
import com.api.netflix.Repositories.userRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping(value ="movies")
public class moviesController {

    private final moviesRepository moviesrepository;
    private final userRepository userepository;

    public moviesController(moviesRepository moviesrepository, userRepository userepository) {
        this.moviesrepository = moviesrepository;
        this.userepository = userepository;
    }

    //retrieve and display all the movies
    @GetMapping
    public List <Movies> pullMovies(){
        return moviesrepository.findAll();

    }
}
