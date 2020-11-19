package com.example.databaseschemas.repositories;

import com.example.databaseschemas.models.DocumentView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DocumentViewRepositoryTest {
    @Autowired
    private DocumentViewRepository repository;

    @Test
    void shouldFindAll() {
        List<DocumentView> resultList = repository.findAll();
        assertThat(resultList)
                .hasSize(1)
                .singleElement()
                .hasFieldOrPropertyWithValue("content", "Document content")
                .hasFieldOrPropertyWithValue("projectTitle", "First Project");
    }
}