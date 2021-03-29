CREATE TABLE IF NOT EXISTS users (
    id bigserial NOT NULL PRIMARY KEY,
    username varchar(100) NOT NULL,
    comment varchar(100)
);

CREATE TABLE IF NOT EXISTS authorities
(
    user_id bigint NOT NULL,
    role varchar(20) NOT NULL,
    CONSTRAINT authorities_user_id_role_key UNIQUE (user_id, role),
    CONSTRAINT fk_authorities_users FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users_audit (
    id bigint NOT NULL,
    REV integer not null,
    REVTYPE smallint,
    REVEND integer,
    username varchar(100),
    PRIMARY KEY (id, REV)
);

CREATE TABLE IF NOT EXISTS roles_audit (
    rev bigint NOT NULL,
    user_id bigint NOT NULL,
    role varchar(20) NOT NULL,
    revtype smallint,

    PRIMARY KEY (rev, user_id, role)
);

CREATE TABLE IF NOT EXISTS REVINFO
(
    REV      bigserial,
    REVTSTMP bigint,
    username varchar(255),
    primary key (REV)
);