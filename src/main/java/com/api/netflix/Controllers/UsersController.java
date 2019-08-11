package com.api.netflix.Controllers;


import com.api.netflix.Models.Movies;
import com.api.netflix.Models.Users;
import com.api.netflix.Repositories.moviesRepository;
import com.api.netflix.Repositories.userRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="users")
public class usersController {

    private final userRepository userRepository;
    private final moviesRepository moviesRepository;

    public usersController(userRepository userRepository, moviesRepository moviesRepository) {
        this.userRepository = userRepository;
        this.moviesRepository = moviesRepository;
    }
    @GetMapping
    public List<Users> pullusers() {
        return userRepository.findAll();

    }

    @GetMapping(value = "{id}")
    public Users findByUserID(@PathVariable Long id) {

        Users users
                = null;
        try {
            users = userRepository.findById(id).orElseThrow(
                    () -> new NotFoundException("no users with the id" + id + "was found"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        users.setId(users.getId());
        users.setFirstName(users.getFirstName());
        users.setNationalID(users.getNationalID());

        return users;
    }


    @PostMapping
    public Users addUser(@RequestBody Users users){
        return userRepository.save(users);
    }




    }
