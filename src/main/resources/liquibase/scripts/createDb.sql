-- liquibase formatted sql

-- changeSet evnag:1
CREATE TABLE socks
(
    id          BIGSERIAL   NOT NULL PRIMARY KEY,
    color       VARCHAR(50) NOT NULL,
    cotton_part INTEGER     NOT NULL
        CONSTRAINT percentage_cotton_part CHECK ( cotton_part > 0 AND cotton_part <= 100)
);

CREATE TABLE total
(
    socks_id       BIGSERIAL NOT NULL PRIMARY KEY,
    total_quantity INTEGER   NOT NULL
        CONSTRAINT positive_total_quantity CHECK (total_quantity > 0),
    date_total     TIME      NOT NULL
);

CREATE TABLE income
(
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    income_quantity INTEGER   NOT NULL
        CONSTRAINT positive_income_quantity CHECK (income_quantity > 0),
    socks_id        BIGINT    NOT NULL,
    date_income     TIME      NOT NULL
);

CREATE TABLE outcome
(
    id               BIGSERIAL NOT NULL PRIMARY KEY,
    outcome_quantity INTEGER   NOT NULL
        CONSTRAINT positive_outcome_quantity CHECK (outcome_quantity > 0),
    socks_id         BIGINT    NOT NULL,
    date_outcome     TIME      NOT NULL
);

-- changeSet evnag:2
ALTER TABLE total
    ADD CONSTRAINT total_socks_id FOREIGN KEY (socks_id) REFERENCES socks (id);

ALTER TABLE income
    ADD CONSTRAINT income_socks_id FOREIGN KEY (socks_id) REFERENCES socks (id);

ALTER TABLE outcome
    ADD CONSTRAINT outcome_socks_id FOREIGN KEY (socks_id) REFERENCES socks (id);

-- changeSet evnag:3
ALTER TABLE total
DROP
COLUMN date_total;
ALTER TABLE total
    ADD
        COLUMN date_total TIMESTAMP NOT NULL;

ALTER TABLE income
DROP
COLUMN date_income;
ALTER TABLE income
    ADD
        COLUMN date_income TIMESTAMP NOT NULL;

ALTER TABLE outcome
DROP
COLUMN date_outcome;
ALTER TABLE outcome
    ADD
        COLUMN date_outcome TIMESTAMP NOT NULL;