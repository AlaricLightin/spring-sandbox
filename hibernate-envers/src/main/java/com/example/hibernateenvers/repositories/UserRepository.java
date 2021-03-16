package com.example.hibernateenvers.repositories;

import com.example.hibernateenvers.domain.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CustomUser, Long> {
}
