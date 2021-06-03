package com.example.onetomanywithcompositekey.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor
@Embeddable
public class ChildId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private ParentEntity parentEntity;

    @Column(name = "additional_id", nullable = false)
    private int additionalId;
}
