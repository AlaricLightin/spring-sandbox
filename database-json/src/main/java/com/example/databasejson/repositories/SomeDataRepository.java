package com.example.databasejson.repositories;

import com.example.databasejson.models.SomeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SomeDataRepository extends JpaRepository<SomeData, Long> {
}
