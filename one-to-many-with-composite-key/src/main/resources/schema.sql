CREATE TABLE parents (
    id serial NOT NULL PRIMARY KEY,
    content varchar
);

CREATE TABLE children (
    parent_id int NOT NULL,
    additional_id int NOT NULL,
    content varchar,

    CONSTRAINT children_pkey PRIMARY KEY (parent_id, additional_id),
    CONSTRAINT children_parent_fkey FOREIGN KEY (parent_id) REFERENCES parents(id)
);