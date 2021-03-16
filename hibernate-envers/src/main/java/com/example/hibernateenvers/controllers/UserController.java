package com.example.hibernateenvers.controllers;

import com.example.hibernateenvers.domain.CustomUser;
import com.example.hibernateenvers.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;

    @GetMapping("/user")
    public List<CustomUser> getUsers() {
        return repository.findAll();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody CustomUser customUser) {
        customUser.setId(0);
        repository.save(customUser);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody CustomUser customUser) {
        customUser.setId(id);
        repository.save(customUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        repository.deleteById(id);
    }
}
