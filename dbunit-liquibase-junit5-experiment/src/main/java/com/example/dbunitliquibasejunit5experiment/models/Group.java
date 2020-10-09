package com.example.dbunitliquibasejunit5experiment.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "my_groups")
@Data
public class Group {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
}
