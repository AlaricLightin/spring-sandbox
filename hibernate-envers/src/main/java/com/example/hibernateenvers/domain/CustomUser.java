package com.example.hibernateenvers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Set;

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

    @ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Fetch(FetchMode.SUBSELECT)
    @Column(name = "role", nullable = false)
    @Audited
    @AuditJoinTable(name = "roles_audit")
    private Set<String> roles;
}
