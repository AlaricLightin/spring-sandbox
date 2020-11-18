package com.example.databaseschemas.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "documents", schema = "documents")
@Data
public class Document {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @Column(name = "content", unique = true)
    private String content;
}
