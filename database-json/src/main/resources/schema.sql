CREATE TABLE json_table (
    id bigserial NOT NULL PRIMARY KEY,
    json_field jsonb
);

CREATE TABLE json_ident_data_table(
    id bigserial NOT NULL PRIMARY KEY,
    ident jsonb,
    value varchar (20)
);