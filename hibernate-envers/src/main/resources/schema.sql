CREATE TABLE IF NOT EXISTS users (
    id bigserial NOT NULL PRIMARY KEY,
    username varchar(100) NOT NULL,
    comment varchar(100)
);

CREATE TABLE IF NOT EXISTS users_audit (
    id bigint NOT NULL,
    REV integer not null,
    REVTYPE smallint,
    REVEND integer,
    username varchar(100),
    PRIMARY KEY (id, REV)
);

CREATE TABLE IF NOT EXISTS REVINFO
(
    REV      bigserial,
    REVTSTMP bigint,
    username varchar(255),
    primary key (REV)
);