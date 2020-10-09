package com.example.dbunitliquibasejunit5experiment.repositories;

import com.example.dbunitliquibasejunit5experiment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
