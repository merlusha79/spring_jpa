CREATE TABLE Player
(
   ID INTEGER NOT NULL,
   Name VARCHAR(255) NOT NULL,
   Nationality VARCHAR(255) NOT NULL,
   Birth_date TIMESTAMP,
   Titles INTEGER,
   PRIMARY KEY (ID)
);

INSERT INTO Player (ID, Name, Nationality, Birth_date, Titles) VALUES(1, 'Djokovic', 'Serbia', '1987-05-22', 81);
INSERT INTO Player (ID, Name, Nationality, Birth_date, Titles) VALUES(2, 'Monfils', 'France', '1986-09-01', 10);
INSERT INTO Player (ID, Name, Nationality, Birth_date, Titles) VALUES(3, 'Isner', 'USA', '1985-04-26', 15);