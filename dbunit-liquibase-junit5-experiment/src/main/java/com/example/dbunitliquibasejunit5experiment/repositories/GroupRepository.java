package com.example.dbunitliquibasejunit5experiment.repositories;

import com.example.dbunitliquibasejunit5experiment.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
