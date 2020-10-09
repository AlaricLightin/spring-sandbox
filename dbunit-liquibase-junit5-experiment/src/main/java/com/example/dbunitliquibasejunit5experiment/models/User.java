package com.example.dbunitliquibasejunit5experiment.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "my_users")
@Data
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Group.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    public User() {
    }

    public User(long id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }
}
