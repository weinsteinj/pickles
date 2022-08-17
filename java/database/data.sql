BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('A','B','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','email@email.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('admin','admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','admin@admin.com','15202');

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
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user1','user1','ROLE_USER','email@email.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user2','user2','ROLE_USER','email@email.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user3','user3','ROLE_USER','email@email.com','15202');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user4','user4','ROLE_USER','email@email.com','15217');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user5','user5','ROLE_USER','email@email.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user6','user6','ROLE_USER','email@email.com','15202');

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user1','user1','ROLE_USER','email@email.com','45214');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user2','user2','ROLE_USER','email@email.com','45201');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user3','user3','ROLE_USER','email@email.com','45202');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user4','user4','ROLE_USER','email@email.com','45203');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user5','user5','ROLE_USER','email@email.com','45204');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('a','b','user6','user6','ROLE_USER','email@email.com','45205');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('Junebug', 'Dog', 'female', '2015-06-10', true, true, 1);

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('Kona', 'Dog', 'female', '2017-04-15', true, true, 1);

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('James Franco', 'Dog', 'male', '2013-08-15', true, true, 3);


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
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 2, '15212', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (2, 4, '15212', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 3, '15202', '2022-09-30T12:00:00', 'Go on a walk with us!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 4, '15203', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (2, 5, '15204', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 6, '15205', '2022-09-30T12:00:00', 'Go on a walk with us!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (4, 2, '15206', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (5, 3, '15207', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (6, 3, '15208', '2022-09-30T12:00:00', 'Go on a walk with us!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (4, 3, '15209', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (5, 2, '15210', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (6, 1, '15217', '2022-09-30T12:00:00', 'Go on a walk with us!');

INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 2, '45201', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (2, 4, '45202', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 3, '45203', '2022-09-30T12:00:00', 'Go on a walk with us!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 4, '45204', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (2, 5, '45205', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (1, 6, '45206', '2022-09-30T12:00:00', 'Go on a walk with us!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (4, 2, '45214', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (5, 3, '45207', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (6, 3, '45208', '2022-09-30T12:00:00', 'Go on a walk with us!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (4, 3, '45209', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (5, 2, '45215', '2022-08-15T12:00:00', 'Super fun playdate at the park!');
INSERT INTO playdate (host_id, visitor_id, zip_code, date_and_time, details) VALUES (6, 1, '45216', '2022-09-30T12:00:00', 'Go on a walk with us!');






--PET PLAYDATES--
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (1, 1);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (1, 2);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (2, 2);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (2, 3);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (3, 1);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (3, 3);

--MARKER INSERTS--
INSERT INTO markers (zip_code, lat, lng) VALUES ('15212', 40.482805, -80.036726);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15202', 40.497452, -80.060345);

INSERT INTO markers (zip_code, lat, lng) VALUES ('15203', 40.429303, -79.972425);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15204', 40.4567689, -80.056286);

INSERT INTO markers (zip_code, lat, lng) VALUES ('15205', 40.441770, -80.087015);

INSERT INTO markers (zip_code, lat, lng) VALUES ('15206', 40.472064, -79.913673);

INSERT INTO markers (zip_code, lat, lng) VALUES ('15207', 40.403418, -79.955328);

INSERT INTO markers (zip_code, lat, lng) VALUES ('15208', 40.450914, -79.902478);


--INSERT INTO markers (zip_code, lat, lng) VALUES ('15209', 40.482805, -80.036726);
--
--INSERT INTO markers (zip_code, lat, lng) VALUES ('15210', 40.497452, -80.060345);
--
--INSERT INTO markers (zip_code, lat, lng) VALUES ('15217', 40.482805, -80.036726);


COMMIT TRANSACTION;
