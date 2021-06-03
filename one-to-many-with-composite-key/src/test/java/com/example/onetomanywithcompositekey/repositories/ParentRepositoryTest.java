package com.example.onetomanywithcompositekey.repositories;

import com.example.onetomanywithcompositekey.entities.ChildEntity;
import com.example.onetomanywithcompositekey.entities.ParentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ParentRepositoryTest {
    @Autowired
    private ParentRepository parentRepository;

    @Test
    void shouldWork() {
        List<ParentEntity> parentEntities = parentRepository.findAll();

        assertThat(parentEntities)
                .hasSize(2)
                .extracting(ParentEntity::getContent)
                .containsExactlyInAnyOrder("parent 1", "parent 2");

        assertThat(parentEntities.get(0).getChildEntityList())
                .hasSize(3)
                .extracting(ChildEntity::getContent)
                .containsExactlyInAnyOrder("child 1-1", "child 1-2", "child 1-3");
    }
}