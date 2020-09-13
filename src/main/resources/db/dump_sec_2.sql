CREATE DATABASE sec ;

use sec ;

CREATE TABLE users (
    username varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    enabled tinyint(1) NOT NULL,

    PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO users
VALUES
('alex', '{noop}123', 1),
('bob', '{noop}123', 1);

CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    UNIQUE KEY authorities_idx_1 (username, authority),

    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username)
    REFERENCES users (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO authorities
VALUES
('alex', 'ROLE_ADMIN'),
('alex', 'ROLE_USER'),
('bob', 'ROLE_USER');
