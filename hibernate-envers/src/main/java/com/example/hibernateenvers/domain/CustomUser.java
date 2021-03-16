package com.example.hibernateenvers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@AuditTable(value = "users_audit")
public class CustomUser {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false)
    @Audited
    private String username;

    @Column(name = "comment", nullable = false)
    private String comment;
}
