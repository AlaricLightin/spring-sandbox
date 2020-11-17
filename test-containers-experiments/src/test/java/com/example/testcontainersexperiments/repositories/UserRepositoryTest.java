package com.example.testcontainersexperiments.repositories;

import com.example.testcontainersexperiments.models.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void shouldFindUsers() {
        List<UserEntity> resultList = repository.findAll();
        assertThat(resultList)
                .hasSize(1)
                .singleElement()
                .hasFieldOrPropertyWithValue("id", 100L)
                .hasFieldOrPropertyWithValue("name", "Name");
    }

    @Test
    void shouldDeleteUser() {
        repository.deleteById(100L);
        repository.flush();

        List<UserEntity> resultList = repository.findAll();
        assertThat(resultList)
                .isEmpty();
    }
}