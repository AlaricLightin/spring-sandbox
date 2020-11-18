package com.example.databaseschemas.repositories;

import com.example.databaseschemas.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
