BEGIN TRANSACTION;
DROP TABLE IF EXISTS users, pets, playdate, pet_playdate, address, personality, pet_personality, messages;

--TABLE CREATION--

CREATE TABLE users
(
	user_id serial,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200),
	role varchar(50),
	email_address varchar(250) NOT NULL,
	birth_date date,
	zip_code int, --NOT NULL
	pickle_points int,

	constraint pk_user PRIMARY KEY (user_id)
);
CREATE TABLE pets
(
	pet_id serial,
	user_id int,
	name varchar(50) NOT NULL,
	species varchar(50) NOT NULL,
	sex varchar(10),
	birth_date date NOT NULL,
	is_fixed boolean NOT NULL,
	has_vaccinations boolean NOT NULL,
	size varchar (15),
	pet_photo varchar (2100),

	constraint pk_pet PRIMARY KEY (pet_id),
	constraint fk_user FOREIGN KEY (user_id) references users (user_id)
);
CREATE TABLE playdate
(
	playdate_id serial,
	host_id int,
	visitor_id int,
	zip_code int,
	date_and_time timestamp,
	details varchar(1000),
	rating int,
	status varchar(10),
	playdate_photo varchar (2100),

	constraint pk_playdate PRIMARY KEY (playdate_id),
	constraint fk_host_id FOREIGN KEY (host_id) references users (user_id),
	constraint fk_visitor_id FOREIGN KEY (visitor_id) references users (user_id)
);
CREATE TABLE pet_playdate
(
	pet_id int NOT NULL,
	playdate_id int NOT NULL,

	constraint fk_pet_playdate_pet_id FOREIGN KEY (pet_id) references pets (pet_id),
	constraint fk_pet_playdate_playdate_id FOREIGN KEY (playdate_id) references playdate (playdate_id)
);
CREATE TABLE address
(
	address_id serial,
	user_id int NOT NULL,
	street_number varchar(20) NOT NULL,
	street varchar(30) NOT NULL,
	city varchar(25) NOT NULL,
	state_abbreviation varchar(2) NOT NULL,

	constraint pk_address_id PRIMARY KEY (address_id),
	constraint fk_user_id FOREIGN KEY (user_id) references users (user_id)

);
CREATE TABLE personality
(
	personality_id serial,
	type varchar(100) UNIQUE NOT NULL,

	constraint pk_personality_id PRIMARY KEY (personality_id)
);
CREATE TABLE pet_personality
(
	pet_id int,
	personality_id int,

	constraint pk_pet_personality PRIMARY KEY (pet_id, personality_id),
	constraint fk_pet_personality_pet_id FOREIGN KEY (pet_id) references pets (pet_id),
	constraint fk_pet_personality_personality_id FOREIGN KEY (personality_id) references personality (personality_id)
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
