package com.example.mvc.demo.mvc.Repositories;

import com.example.mvc.demo.mvc.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {
    User findByName(String name);
}
