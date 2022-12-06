DROP TABLE IF EXISTS performer_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS performer;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS performer_type;

CREATE TABLE performer_type (
	type_id serial NOT NULL,
	type_name varchar(50),
	CONSTRAINT PK_type PRIMARY KEY (type_id),
	CONSTRAINT UQ_type UNIQUE (type_name)
);

CREATE TABLE equipment (
	eq_id serial NOT NULL,
	eq_name varchar(100) NOT NULL,
	CONSTRAINT PK_equipment PRIMARY KEY (eq_id),
	CONSTRAINT UQ_equipment UNIQUE (eq_name)
);

CREATE TABLE performer (
	performer_id serial NOT NULL,
	type_id int NOT NULL,
	performer_name varchar(100) NOT NULL,
	email varchar(60) NOT NULL,
	phone_number varchar(16) NULL,
	eq_id int NOT NULL,
	soundcloud_url text NULL,
	CONSTRAINT PK_performer PRIMARY KEY (performer_id),
	CONSTRAINT FK_performer_type FOREIGN KEY (type_id) REFERENCES performer_type (type_id),
	CONSTRAINT FK_equipment_performer FOREIGN KEY (eq_id) REFERENCES equipment (eq_id),
	CONSTRAINT UQ_email UNIQUE (email),
	CONSTRAINT CHL_soudcloud CHECK(soundcloud_url LIKE '%soundcloud.com%')
);

CREATE TABLE genre (
	genre_id serial NOT NULL,
	genre_name varchar(50),
	CONSTRAINT PK_genre PRIMARY KEY (genre_id),
	CONSTRAINT UQ_genre UNIQUE (genre_name)
);

CREATE TABLE performer_genre (
	performer_id int NOT NULL,
	genre_id int NOT NULL,
	CONSTRAINT PK_performer_genre PRIMARY KEY (performer_id, genre_id),
	CONSTRAINT FK_performer_genre_performer FOREIGN KEY (performer_id) REFERENCES performer (performer_id),
	CONSTRAINT FK_performer_genre_genre FOREIGN KEY (genre_id) REFERENCES genre (genre_id)
);

INSERT INTO performer_type (type_name) VALUES
	('Band'),
	('DJ'),
	('Soloist');
	
INSERT INTO equipment (eq_name) VALUES
	('Amps, drumset, soundsystem, keyboard, mics'),
	('Piano, soundsystem, mic'),
	('Amps, soundsystem, mics'),
	('DJ Decks (2), soundsystem'),
	('DJ Decks (3), soundsystem'),
	('DJ Decks (4), soundsystem');

INSERT INTO performer (type_id, performer_name, email, phone_number, eq_id, soundcloud_url) VALUES
	(1, 'Daisy Grenade', 'daisy@fake.com', '298-345-2433', 1, 'www.soundcloud.com/daisyg'),
	(2, 'DJ Jessica', 'djjess@fake.com', '298-276-3876', 6, 'www.soundcloud.com/djjess'),
	(2, 'Mui Mui', 'muimuidj@fake.com', '298-345-1233', 4, 'www.soundcloud.com/muimui'),
	(3, 'Adele2.0', 'adele2@fake.com', '298-235-4768', 2, 'www.soundcloud.com/adele2'),
	(1, 'The Kinks', 'kinks@fake.com', '298-234-2433', 1, 'www.soundcloud.com/daisyg'),
	(2, 'Volvox', 'vlvx@fake.com', '458-225-2433', 5, 'www.soundcloud.com/volvox'),
	(3, 'Ella Fitzgerald', 'ellaf@fake.com', '298-245-1323', 2, 'www.soundcloud.com/ella'),
	(2, 'Maraschino BB', 'mrschnobb@fake.com', '298-094-2433', 4, 'www.soundcloud.com/maraschinobb');
	
SELECT * FROM performer;

INSERT INTO genre (genre_name) VALUES
	('House'),
	('Techno'),
	('Jazz'),
	('Punk'),
	('Rock'),
	('Pop'),
	('Hip-Hop'),
	('Electro');
	
INSERT INTO performer_genre (performer_id, genre_id) VALUES 
	(1, 4),
	(1, 5),
	(2, 2),
	(2, 1),
	(3, 2),
	(3, 8),
	(4, 6),
	(5, 2),
	(6, 5),
	(7, 3),
	(8, 1),
	(8, 7),
	(8, 8);

SELECT * FROM performer;

SELECT performer.performer_id, type_id, performer_name, email, phone_number, eq_id, soundcloud_url FROM performer
                    JOIN performer_genre ON performer_genre.performer_id = performer.performer_id
                    WHERE genre_id = 3;



