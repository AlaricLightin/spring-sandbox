package com.example.databaseschemas.models;

import lombok.Data;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "projects", schema = "projects")
@Data
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", unique = true)
    private String title;
}
