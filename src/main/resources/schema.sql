create table IF NOT EXISTS users
(
    userid       SERIAL      NOT NULL PRIMARY KEY,
    login    VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL

);

CREATE TABLE IF NOT EXISTS records
(
    id     SERIAL      NOT NULL PRIMARY KEY,
    userid INT         NOT NULL REFERENCES users (userid) ON DELETE CASCADE,
    game   VARCHAR(32) NOT NULL,
    score  INT         NOT NULL
);