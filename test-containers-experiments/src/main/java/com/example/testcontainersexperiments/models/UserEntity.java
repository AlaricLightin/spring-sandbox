package com.example.testcontainersexperiments.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    public UserEntity() {
    }

    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
