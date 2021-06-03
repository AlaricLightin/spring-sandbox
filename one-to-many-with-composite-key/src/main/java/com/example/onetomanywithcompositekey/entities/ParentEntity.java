package com.example.onetomanywithcompositekey.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "parents")
@Data
@NoArgsConstructor
public class ParentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "childId.parentEntity")
    private List<ChildEntity> childEntityList;
}
