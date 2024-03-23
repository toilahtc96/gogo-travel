CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       full_name VARCHAR(255),
                       phone VARCHAR(20),
                       email VARCHAR(255) NOT NULL,
                       status ENUM('ACTIVE','BLOCK') DEFAULT 'ACTIVE',
                       created_time TIME
);

CREATE TABLE posts (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id INT NOT NULL,
                       title VARCHAR(255) NOT NULL,
                       content TEXT,
                       thumbnail VARCHAR(255),
                       content_image VARCHAR(255),
                       status ENUM('ACTIVE','BLOCK') DEFAULT 'ACTIVE',
                       created_time TIME
);

CREATE TABLE registrations (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               post_id INT NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               phone VARCHAR(20),
                               status ENUM('ACTIVE','BLOCK') DEFAULT 'ACTIVE',
                               created_time TIME
);

CREATE TABLE address (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         address_name VARCHAR(255),
                         detail TEXT,
                         thumbnail VARCHAR(255),
                         status ENUM('ACTIVE','BLOCK') DEFAULT 'ACTIVE',
                         created_time TIME
);

CREATE TABLE role (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      role_name VARCHAR(255),
                      status ENUM('ACTIVE','BLOCK') DEFAULT 'ACTIVE',
                      detail TEXT,
                      created_time TIME
);

commit;