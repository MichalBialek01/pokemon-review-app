CREATE TABLE roles(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(16) NOT NULL
);

INSERT INTO roles (id, name) VALUES
                                 (1, 'ADMIN'),
                                 (2, 'USER');