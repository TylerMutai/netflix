package com.api.netflix.Controllers;

import com.api.netflix.Models.Movies;
import com.api.netflix.Models.Users;
import com.api.netflix.Repositories.MoviesRepository;
import com.api.netflix.Repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;
import com.api.netflix.NotFoundException;
import java.util.List;

@RestController
@RequestMapping(value ="users")
public class UsersController {

    private final MoviesRepository moviesRepository;
    private final UsersRepository usersRepository;

    public UsersController(MoviesRepository moviesRepository, UsersRepository usersRepository) {
        this.moviesRepository = moviesRepository;
        this.usersRepository = usersRepository;
    }

//    RETRIEVE ALL USERS
    @GetMapping
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

//    RETRIEVE A USER BY ID
    @GetMapping(value = "{id}")
    public Users findUserByID(@PathVariable Long id) {
        Users users = usersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No user with ID: " + id + " was found")
        );
        usersRepository.save(users);
        return users;
    }

    //    CREATE A USER
    @PostMapping
    public Users createUser(@RequestBody Users users) {
        return usersRepository.save(users);
    }

    //    DELETE A USER
    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable Long id) {
        usersRepository.deleteById(id);
    }

//    //      SEARCH FOR USERS BY FIRST NAME STARTING WITH
//    @GetMapping(value = "search")
//    public List<Users> search(@RequestParam String firstName) {
//        return usersRepository.findByFirstNameStartingWith(firstName);
//    }


//    ----------------------------------------MOVIES---------------------------------------------------------------

    //    GET ALL MOVIES FOR ONE USER USING THEIR NATIONAL ID
    @GetMapping(value = "{nationalId}/movies")
    public List<Movies> findMoviesByUserNationalID(@PathVariable Integer nationalId) {
        return moviesRepository.findByUsers_NationalID(nationalId);
    }

    //    CREATE A MOVIE
    @PostMapping(value = "{id}/movies")
    public Movies createAMovie(@PathVariable Long id, @RequestBody Movies movies) {
        Users user = findUserByID(id);
        movies.setUsers(user);
        movies.setMovieType("Suggested");
        return moviesRepository.save(movies);
    }

    //    DELETE A MOVIE
    @DeleteMapping(value = "{nationalId}/movies/{id}")
    public void deleteCourse(@PathVariable Long id, @PathVariable Integer nationalId) {
        moviesRepository.findByUsers_NationalID(nationalId);
        moviesRepository.deleteById(id);
    }
}
