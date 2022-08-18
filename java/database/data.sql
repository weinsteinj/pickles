BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('A','B','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','email@email.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('admin','admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','admin@admin.com','15202');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('aubrey','t','Flopmom','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','aubrey@aubrey.com','15224');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('nicholas','s','Nickles-and-Pickles','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','nicholas@picholas.com','15068');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('bradley','m','JamesFrancophile','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','bradley@bradley.com','45214');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('caito','n','Junebuggy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','caito@caito.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('josh','w','Voltron4life','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','josh@josh.com','15217');


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


INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
VALUES ('Kona', 'Dog', 'female', '2017-04-15', true, true, 1, 'https://res.cloudinary.com/picklepoints/image/upload/v1660761571/p78ufgsztlhufjyovc5e.jpg');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
VALUES ('Griffon', 'Dog', 'male', '2017-07-01', true, true, 3, 'https://res.cloudinary.com/picklepoints/image/upload/v1660835073/IMG_7889_wy1qnp.jpg');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
VALUES ('Flop', 'Cat', 'male', '2020-01-01', true, true, 1, 'https://res.cloudinary.com/picklepoints/image/upload/v1660677150/syttdmrns74fx5ayayrb.jpg');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
VALUES ('Pickles', 'Reptile', 'male', '2005-07-01', false, false, 1, 'https://res.cloudinary.com/picklepoints/image/upload/v1660761411/hx2ffssdor562smvaum8.jpg');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
VALUES ('James Franco', 'Dog', 'male', '2013-08-15', true, true, 3, 'https://res.cloudinary.com/picklepoints/image/upload/v1660569566/jcr7imrmybcahzdiwvch.jpg');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
VALUES ('Junebug', 'Dog', 'female', '2015-06-10', true, true, 1, 'https://res.cloudinary.com/picklepoints/image/upload/v1660605009/lhvfp8ydmzsauxxwvnpb.jpg');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
VALUES ('Voltron', 'Other', 'male', '1984-01-01', false, false, 5, 'https://res.cloudinary.com/picklepoints/image/upload/v1660833307/Voltron-Live-Action-Movie_fwhyea.jpg');




--USER IDS IN PETS--
UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'Junebuggy')
WHERE name = 'Junebug';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'user')
WHERE name = 'Kona';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'admin')
WHERE name = 'Griffon';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'JamesFrancophile')
WHERE name = 'James Franco';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'Flopmom')
WHERE name = 'Flop';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'Voltron4life')
WHERE name = 'Voltron';

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'Nickles-and-Pickles')
WHERE name = 'Pickles';


--PET PERSONALITIES--

INSERT INTO pet_personality (pet_id, personality_id) VALUES (1,2);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (2,4);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (1,6);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (3,1);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (4,3);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (5,2);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (6,4);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (6,6);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (7,1);
INSERT INTO pet_personality (pet_id, personality_id) VALUES (3,3);




-- --PLAYDATES--
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (1, '15202', '2022-09-30T12:00:00', 'Go on a walk with us!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660750512/xxc1pbb8avuzbxw3n0os.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (2, '15212', '2022-08-15T12:00:00', 'Super fun playdate at the park!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660577639/z2qy9virlkkpwehypxcl.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (3, '15224', '2022-08-15T12:00:00', 'Flop needs a nap buddy.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660761609/ssz1fqrza97qtqwrib57.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (4, '15068', '2022-08-22T12:00:00', 'A birthday party for my turtle Pickles!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660786126/upetkwiod7otqipihv4l.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, '45214', '2022-09-30T12:00:00', 'Even James Franco needs a friend!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836414/a4f191c0ed6bb46091476d2620ae31cab2-jamesfranco.rsquare.w330_ji1vaf.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (6, '15212', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660765957/etp5bb0ivqtyokwn8ivc.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (7, '15217', '2022-08-22T12:00:00', 'Let’s Fly Into The Cosmic Death Storm.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836623/voltron-seasons-3-6-dvd-release_rnhohd.jpg');
--INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, '15207', '2022-08-15T12:00:00', 'Super fun playdate at the park!', 'https://www.flickr.com/photos/jimwallace57/5774022019/');
--INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (6, '15208', '2022-09-30T12:00:00', 'Go on a walk with us!', 'https://www.flickr.com/photos/omardearmas/3357451975/');


--PET PLAYDATES--
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (1, 1);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (2, 2);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (3, 3);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (4, 4);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (5, 5);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (6, 6);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (7, 7);


--MARKER INSERTS--
INSERT INTO markers (zip_code, lat, lng) VALUES ('15212', 40.482805, -80.036726);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15202', 40.497452, -80.060345);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15203', 40.429303, -79.972425);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15204', 40.4567689, -80.056286);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15205', 40.441770, -80.087015);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15206', 40.472064, -79.913673);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15207', 40.403418, -79.955328);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15208', 40.450914, -79.902478);



COMMIT TRANSACTION;
