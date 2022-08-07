BEGIN TRANSACTION;
DROP TABLE IF EXISTS users, pets, playdate, pet_playdate, user_pet, messages;

--TABLE CREATION--

CREATE TABLE users
(
	user_id serial,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200),
	role varchar(50) NOT NULL,
	email_address varchar(250) NOT NULL,
	address varchar(500) NOT NULL,
	birth_date date,
	pickle_points int,

	constraint pk_user PRIMARY KEY (user_id)
);
CREATE TABLE pets
(
	pet_id serial,
	name varchar(50) NOT NULL,
	species varchar(50) NOT NULL,
	sex varchar(10),
	birth_date date NOT NULL,
	personality varchar(1500) NOT NULL,
	is_fixed boolean NOT NULL,
	has_vaccinations boolean NOT NULL,
	size varchar (15),

	constraint pk_pet PRIMARY KEY (pet_id)
);
CREATE TABLE playdate
(
	playdate_id serial,
	location varchar(500) NOT NULL,
	date_and_time timestamp NOT NULL,
	details varchar(1000),
	rating int,
	status varchar(10),

	constraint pk_playdate PRIMARY KEY (playdate_id)
);
CREATE TABLE pet_playdate
(
	pet_id int NOT NULL,
	playdate_id int NOT NULL,

	constraint pk_pet_playdate PRIMARY KEY (pet_id, playdate_id),
	constraint fk_pet_playdate_pet_id FOREIGN KEY (pet_id) references pets (pet_id),
	constraint fk_pet_playdate_playdate_id FOREIGN KEY (playdate_id) references playdate (playdate_id)
);
CREATE TABLE user_pet
(
	user_id int NOT NULL,
	pet_id int NOT NULL,

	constraint pk_user_pet PRIMARY KEY (user_id, pet_id),
	constraint fk_user_pet_user_id FOREIGN KEY (user_id) references users (user_id),
	constraint fk_user_pet_pet_id FOREIGN KEY (pet_id) references pets (pet_id)
);
CREATE TABLE messages
(
	message_id serial,
	body varchar(1500),
	user_id int,

	constraint pk_message PRIMARY KEY (message_id),
	constraint fk_user FOREIGN KEY (user_id) references users (user_id)
);

COMMIT TRANSACTION;
