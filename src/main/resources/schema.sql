
CREATE TABLE IF NOT EXISTS users  (
        id BIGINT PRIMARY KEY ,
        login varchar(255) NOT NULL,
        password varchar(255) NOT NULL,
        email varchar(100) NOT NULL,
        name varchar(100) NOT NULL,
        surname varchar(100) NOT NULL,
        admin boolean NOT NULL
);


CREATE TABLE IF NOT EXISTS tasks  (
    id BIGINT PRIMARY KEY,
    number integer NOT NULL,
    section varchar(255),
    description varchar(1000),
    file_path varchar(100),
    attempts_max integer,
    task_name varchar(100)
);


CREATE TABLE IF NOT EXISTS users_tasks  (
    user_id BIGINT REFERENCES users(id),
    task_id BIGINT REFERENCES tasks(id),
    progress NUMERIC NOT NULL,
    path_result varchar(255) NOT NULL,
    attempt_number integer NOT NULL,
    time timestamp,
    log varchar(255) NOT NULL,
    code varchar(1000) NOT NULL,
    CONSTRAINT users_tasks_pk PRIMARY KEY (user_id, task_id)
);


/*INSERT INTO users VALUES (1, 'lalal', 'pass', 'email', 'name', 'surname', false);*/
INSERT INTO tasks VALUES (1, 1, '1', '1', '/1', 1 ,'one');
INSERT INTO users_tasks VALUES (1, 1, 0, 'lalal', 0, null, 'logarifm', 'code');