package com.example.databasejson.repositories;

import com.example.databasejson.models.SomeData;
import com.example.databasejson.models.SomeJsonData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SomeDataRepositoryTest {
    @Autowired
    SomeDataRepository repository;

    @Test
    void shouldRead() {
        List<SomeData> result = repository.findAll();
        assertThat(result)
                .hasSize(1)
                .extracting(SomeData::getJsonData)
                .element(0)
                .hasFieldOrPropertyWithValue("intField", 10)
                .hasFieldOrPropertyWithValue("stringField", "String 1");
    }

    @Test
    void shouldWrite() {
        SomeData someData = new SomeData();
        someData.setJsonData(new SomeJsonData(5, "555"));
        repository.saveAndFlush(someData);

        List<SomeData> result = repository.findAll();
        assertThat(result)
                .hasSize(2)
                .anySatisfy(d -> assertThat(d)
                        .extracting(SomeData::getJsonData)
                        .hasFieldOrPropertyWithValue("stringField", "555"));
    }
}