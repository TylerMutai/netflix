package com.api.netflix.TestData;


import com.api.netflix.Repositories.MoviesRepository;
import com.api.netflix.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppTest implements CommandLineRunner {


    private final MoviesRepository moviesRepository;
    private final UserRepository userRepository;

    public AppTest(MoviesRepository moviesController, UserRepository userController) {
        this.moviesRepository = moviesController;
        this.userRepository = userController;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
