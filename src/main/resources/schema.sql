DROP table USERS;

CREATE TABLE IF NOT EXISTS users  (
        id BIGINT PRIMARY KEY ,
        login varchar(255) NOT NULL,
        password varchar(255) NOT NULL,
        email varchar(100) NOT NULL,
        name varchar(100) NOT NULL,
        surname varchar(100) NOT NULL,
        admin boolean NOT NULL
);

INSERT INTO users VALUES (1, 'lalal', 'pass', 'email', 'name', 'surname', false);