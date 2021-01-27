package com.example.databasejson.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Map;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "json_ident_data_table")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
@NoArgsConstructor
public class DataWithIdent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "jsonb")
    @Column(name = "ident", columnDefinition = "jsonb")
    Map<String, Object> identMap;

    @Column(name = "value")
    String value;
}
