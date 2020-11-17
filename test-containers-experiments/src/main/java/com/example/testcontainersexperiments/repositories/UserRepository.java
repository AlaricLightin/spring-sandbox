package com.example.testcontainersexperiments.repositories;

import com.example.testcontainersexperiments.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
