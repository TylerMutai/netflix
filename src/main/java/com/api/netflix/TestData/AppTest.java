package com.api.netflix.TestData;


import com.api.netflix.Models.Movies;
import com.api.netflix.Repositories.moviesRepository;
import com.api.netflix.Repositories.userRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class AppTest implements CommandLineRunner {


    private final moviesRepository moviesRepository;
    private final userRepository userRepository;

    public AppTest(moviesRepository moviesController, userRepository userController) {
        this.moviesRepository = moviesController;
        this.userRepository = userController;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
