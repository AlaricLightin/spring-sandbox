package com.example.dbunitliquibasejunit5experiment.repositories;

import com.example.dbunitliquibasejunit5experiment.models.Group;
import com.example.dbunitliquibasejunit5experiment.models.User;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DBRider
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Test
    @DataSet("started-set.yml")
    @ExpectedDataSet("expected-result.yml")
    void shouldAddUser() {
        Group group = groupRepository.getOne(1L);
        User user = new User(2L, "Username2", group);
        userRepository.save(user);
    }

    @Test
    @DataSet("started-set.yml")
    @ExpectedDataSet("expected-empty.yml")
    void shouldDeleteUser() {
        userRepository.deleteById(1L);
    }
}