package com.api.netflix.Repositories;

import com.api.netflix.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<Users, Long> {
}
