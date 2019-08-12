package com.api.netflix.TestData;


import com.api.netflix.Models.Movies;
import com.api.netflix.Repositories.MoviesRepository;
import com.api.netflix.Repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class AppTest implements CommandLineRunner {


    private final MoviesRepository moviesRepository;
    private final UsersRepository usersRepository;

    public AppTest(MoviesRepository moviesRepository, UsersRepository usersRepository) {
        this.moviesRepository = moviesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... args) throws Exception { }
}
