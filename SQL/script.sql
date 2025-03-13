CREATE DATABASE sportflow;
USE sportflow;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('membre', 'trainer') NOT NULL
);

CREATE TABLE membres (
    membre_id INT PRIMARY KEY,
    date_naissance DATE NOT NULL,
    sport VARCHAR(255) NOT NULL,
    FOREIGN KEY (membre_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE trainers (
    trainer_id INT PRIMARY KEY,
    specialite VARCHAR(255) NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE seances (
    idseance INT AUTO_INCREMENT PRIMARY KEY,
    dateSeances DATE NOT NULL,
    heure TIME NOT NULL,
    trainer_id INT NOT NULL,
    membre_id INT NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES trainers(trainer_id) ON DELETE CASCADE,
    FOREIGN KEY (membre_id) REFERENCES membres(membre_id) ON DELETE CASCADE
);
select * from seances;
show tables;
select * from users;
select * from membres;
select * from trainers;
