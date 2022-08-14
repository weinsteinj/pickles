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

--USER INSERTS--
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user1','user1','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user2','user2','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user3','user3','ROLE_USER','email@email.com');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('Junebug', 'dog', 'female', '2015-06-10', true, true, 1);

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('Kona', 'dog', 'female', '2017-04-15', true, true, 1);

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('James Franco', 'dog', 'male', '2013-08-15', true, true, 3);


--USER IDS IN PETS--
UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'user1')
WHERE name = 'Junebug';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'user2')
WHERE name = 'Kona';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'user3')
WHERE name = 'James Franco';

--PET PERSONALITIES--

INSERT INTO pet_personality (pet_id, personality_id) VALUES (1,2);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (2,4);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (1,6);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (3,1);


-- --PLAYDATES--
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details)
VALUES (1, 2, '15212', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');

INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details)
VALUES (2, 3, '15212', '2022-08-15T12:00:00', 'Super fun playdate at the park!');

INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details)
VALUES (1, 3, '15202', '2022-09-30T12:00:00', 'Go on a walk with us!');

--PET PLAYDATES--
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (1, 1);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (1, 2);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (2, 2);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (2, 3);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (3, 1);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (3, 3);

COMMIT TRANSACTION;
