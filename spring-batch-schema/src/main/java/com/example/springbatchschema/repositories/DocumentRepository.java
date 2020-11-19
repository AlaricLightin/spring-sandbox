package com.example.springbatchschema.repositories;

import com.example.springbatchschema.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
