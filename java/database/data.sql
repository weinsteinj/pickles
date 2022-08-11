BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('A','B','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','email@email.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('admin','admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','admin@admin.com','45214');

----PERSONALITY INSERTS--

INSERT INTO personality(type)
VALUES ('timid');

INSERT INTO personality(type)
VALUES ('tires quickly');

INSERT INTO personality(type)
VALUES ('independent');

INSERT INTO personality(type)
VALUES ('playful');

INSERT INTO personality(type)
VALUES ('toy sharing');

INSERT INTO personality(type)
VALUES ('confident');

INSERT INTO personality(type)
VALUES ('high energy');

INSERT INTO personality(type)
VALUES ('toy possessive');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('Junebug', 'dog', 'female', '2015-06-10', true, true, 1);

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('Kona', 'dog', 'female', '2017-04-15', true, true, 1);

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('James Franco', 'dog', 'male', '2013-08-15', true, true, 3);


--USER IDS IN PETS--
UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE first_name = 'A')
WHERE name = 'Junebug';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE first_name = 'A')
WHERE name = 'Kona';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE first_name = 'admin')
WHERE name = 'James Franco';

--PET PERSONALITIES--

INSERT INTO pet_personality (pet_id, personality_id) VALUES (1,2);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (2,4);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (1,6);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (3,1);





COMMIT TRANSACTION;
