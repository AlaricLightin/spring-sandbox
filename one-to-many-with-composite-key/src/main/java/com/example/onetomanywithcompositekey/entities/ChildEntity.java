package com.example.onetomanywithcompositekey.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "children")
@Data
@NoArgsConstructor
public class ChildEntity {
    @EmbeddedId
    private ChildId childId;

    @Column(name = "content")
    private String content;
}
