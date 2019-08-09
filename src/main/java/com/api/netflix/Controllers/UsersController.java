package com.api.netflix.Controllers;

import com.api.netflix.Models.Users;
import com.api.netflix.Repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="users")

public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    RETRIEVE ALL USERS
    @GetMapping
    private List<Users> getAllUsers() {
        return userRepository.findAll();
    }

//    RETRIEVE A USER BY ID
    @GetMapping(value = "{id}")
    public Users findByUserID(@PathVariable Long id) {

        Users users = null;

        try {
            users = userRepository.findById(id).orElseThrow(
                    () -> new NotFoundException("No user with the id:- " + id + " was found"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        users.setId(users.getId());
        users.setFirstName(users.getFirstName());
        users.setNationalID(users.getNationalID());

        return users;
    }

//    CREATE A USER
    @PostMapping()
    public Users createUser(@RequestBody Users users) {
        return userRepository.save(users);
    }

//    DELETE A USER
    @DeleteMapping(value = "{id}")
    public void deleteUniversity(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
