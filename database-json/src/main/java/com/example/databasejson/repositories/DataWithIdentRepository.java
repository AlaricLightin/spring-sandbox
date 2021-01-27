package com.example.databasejson.repositories;

import com.example.databasejson.models.DataWithIdent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SuppressWarnings("SqlNoDataSourceInspection")
public interface DataWithIdentRepository extends JpaRepository<DataWithIdent, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM json_ident_data_table " +
                    "WHERE ident @> CAST (:ident AS jsonb)"
    )
    List<DataWithIdent> searchByIdent(String ident);
}
