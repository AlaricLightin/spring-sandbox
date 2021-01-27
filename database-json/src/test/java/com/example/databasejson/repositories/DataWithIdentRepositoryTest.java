package com.example.databasejson.repositories;

import com.example.databasejson.models.DataWithIdent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DataWithIdentRepositoryTest {
    @Autowired
    private DataWithIdentRepository repository;

    @Test
    void shouldReadAll() {
        List<DataWithIdent> result = repository.findAll();
        assertThat(result)
                .hasSize(3)
                .extracting(DataWithIdent::getIdentMap)
                .extracting(m -> m.get("b"))
                .contains(1, 2, null);
    }

    @Test
    void shouldSearchByAB() {
        List<DataWithIdent> result = repository.searchByIdent(
                String.format("{\"a\": %d, \"b\": %d}", 1, 2)
        );
        assertThat(result)
                .extracting(DataWithIdent::getValue)
                .contains("Value1");
    }
}