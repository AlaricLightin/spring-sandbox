package com.example.testcontainersexperiments.controllers;

import com.example.testcontainersexperiments.models.UserEntity;
import com.example.testcontainersexperiments.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return repository.findAll();
    }
}
