package com.api.netflix.Repositories;

import com.api.netflix.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users>findByFirstNameStartingWith(String name);
    List<Users>findByNationalID(Integer nationalID);
}
