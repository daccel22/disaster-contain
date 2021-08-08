# disaster-contain
1. Web
  - Install Docker Desktop.
  - Install mariadb docker image and run mariadb docker container. ex. `docker run --name mariadb -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mariadb`
  - Login into mariadb command prompt and create a new user with all privileges. ex. `CREATE USER 'user_name'@'%' IDENTIFIED BY 'password';` `GRANT ALL PRIVILEGES ON * . * TO 'user_name'@'%';`
  - In mariadb command prompt, run `CREATE DATABASE disaster_contain;`
  - (Oprional) In mariadb command prompt, run 
  ```USE disaster_contain;
CREATE TABLE `floods` (
  `id` BigInt NOT NULL,
  `startLocationLongitude` float DEFAULT NULL,
  `startLocationLatitudee` float DEFAULT NULL,
  `endLocationLongitude` float DEFAULT NULL,
  `endLocationLatitude` float DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `InsertTS` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
and
  USE disaster_contain;
CREATE TABLE `victims` (
  `id` BigInt NOT NULL,
  `reporterName` VARCHAR(30) DEFAULT NULL,
  `reporterPhoneNumber` VARCHAR(20) DEFAULT NULL,
  `locationLongitude` float DEFAULT NULL,
  `locationLatitude` float DEFAULT NULL,
  `numberOfPeople` INT DEFAULT NULL,
  `severity` INT DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `InsertTS` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
  - In `application.properties` Change the `datasource.url` with host ip address and mariadb assigned port number. Add the newly created user's info to the `datasource.username` and `datasource.password`.
  - Run as spring boot project.
  - Open user page `http://localhost:8080/user.html`
