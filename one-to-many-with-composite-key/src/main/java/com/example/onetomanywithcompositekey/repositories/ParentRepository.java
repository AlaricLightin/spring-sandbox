package com.example.onetomanywithcompositekey.repositories;

import com.example.onetomanywithcompositekey.entities.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<ParentEntity, Integer> {
}
