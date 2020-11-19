package com.example.databaseschemas.models;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Immutable
@Table(name = "v_documents", schema = "documents")
@Data
public class DocumentView {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "project_title")
    private String projectTitle;
}
