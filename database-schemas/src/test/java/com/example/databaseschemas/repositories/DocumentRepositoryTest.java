package com.example.databaseschemas.repositories;

import com.example.databaseschemas.models.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DocumentRepositoryTest {
    @Autowired
    private DocumentRepository repository;

    @Test
    void shouldFindAll() {
        List<Document> resultList = repository.findAll();

        assertThat(resultList)
                .hasSize(1)
                .singleElement()
                .hasFieldOrPropertyWithValue("content", "Document content")
                .satisfies(d -> assertThat(d.getProject())
                        .hasFieldOrPropertyWithValue("title", "First Project"));
    }
}