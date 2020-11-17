package com.example.testcontainersexperiments.repositories;

import com.example.testcontainersexperiments.models.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositorySecondTest {
    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void shouldFindUsers() {
        UserEntity user = new UserEntity(0, "Another name");
        testEntityManager.persistAndFlush(user);

        List<UserEntity> resultList = repository.findAll();
        assertThat(resultList)
                .hasSize(2);
    }

}