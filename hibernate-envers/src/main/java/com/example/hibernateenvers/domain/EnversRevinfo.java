package com.example.hibernateenvers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "REVINFO")
@RevisionEntity(CustomRevisionListener.class)
public class EnversRevinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REV")
    @RevisionNumber
    private long id;

    @RevisionTimestamp
    @Column(name = "REVTSTMP")
    private long timestamp;

    @Column(name = "username")
    private String username;
}
