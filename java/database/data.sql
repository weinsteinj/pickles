BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('A','B','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','email@email.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('admin','admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','admin@admin.com','15202');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('aubrey','t','Flopmom','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','aubrey@aubrey.com','15224');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('nicholas','s','Nickles-and-Pickles','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','nicholas@picholas.com','15068');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('bradley','m','JamesFrancophile','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','bradley@bradley.com','45214');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('caito','n','Junebuggy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','caito@caito.com','15212');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('josh','w','Voltron4life','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','josh@josh.com','15217');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address,zip_code) VALUES ('joe','w','VoltronLives','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'john@john.com','14213');

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

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size, pet_photo)
 VALUES ('Voltron2', 'Other', 'male', '2020-01-01', false, false, 5, 'https://res.cloudinary.com/picklepoints/image/upload/v1660833307/Voltron-Live-Action-Movie_fwhyea.jpg');



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

UPDATE pets
SET user_id = (SELECT user_id FROM users WHERE username = 'VoltronLives')
WHERE name = 'Voltron2';


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
INSERT INTO pet_personality (pet_id, personality_id) VALUES (8,6);




-- --PLAYDATES--
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (1, '15202', '2022-09-30T12:00:00', 'Go on a walk with us!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660750512/xxc1pbb8avuzbxw3n0os.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (2, '15212', '2022-08-15T12:00:00', 'Super fun playdate at the park!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660577639/z2qy9virlkkpwehypxcl.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (3, '15224', '2022-08-15T12:00:00', 'Flop needs a nap buddy.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660761609/ssz1fqrza97qtqwrib57.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (4, '15068', '2022-08-22T12:00:00', 'A birthday party for my turtle Pickles!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660786126/upetkwiod7otqipihv4l.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, '45214', '2022-09-30T12:00:00', 'Even James Franco needs a friend!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836414/a4f191c0ed6bb46091476d2620ae31cab2-jamesfranco.rsquare.w330_ji1vaf.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (6, '15212', '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660765957/etp5bb0ivqtyokwn8ivc.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (7, '15217', '2022-08-22T12:00:00', 'Let’s Fly Into The Cosmic Death Storm.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836623/voltron-seasons-3-6-dvd-release_rnhohd.jpg');

INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, 45201, '2022-09-30T12:00:00', 'Go on a walk with us!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660750512/xxc1pbb8avuzbxw3n0os.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, 45202, '2022-08-15T12:00:00', 'Super fun playdate at the park!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660577639/z2qy9virlkkpwehypxcl.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, 45203, '2022-08-15T12:00:00', 'Flop needs a nap buddy.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660761609/ssz1fqrza97qtqwrib57.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, 45204, '2022-08-22T12:00:00', 'A birthday party for my turtle Pickles!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660786126/upetkwiod7otqipihv4l.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, 45205, '2022-09-30T12:00:00', 'Even James Franco needs a friend!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836414/a4f191c0ed6bb46091476d2620ae31cab2-jamesfranco.rsquare.w330_ji1vaf.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, 45206, '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660765957/etp5bb0ivqtyokwn8ivc.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (5, 45207, '2022-08-22T12:00:00', 'Let’s Fly Into The Cosmic Death Storm.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836623/voltron-seasons-3-6-dvd-release_rnhohd.jpg');

INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (3, 15202, '2022-09-30T12:00:00', 'Go on a walk with us!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660750512/xxc1pbb8avuzbxw3n0os.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (4, 15202, '2022-08-15T12:00:00', 'Super fun playdate at the park!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660577639/z2qy9virlkkpwehypxcl.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (6, 15203, '2022-08-15T12:00:00', 'Flop needs a nap buddy.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660761609/ssz1fqrza97qtqwrib57.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (7, 15204, '2022-08-22T12:00:00', 'A birthday party for my turtle Pickles!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660786126/upetkwiod7otqipihv4l.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (3, 15205, '2022-09-30T12:00:00', 'Even James Franco needs a friend!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836414/a4f191c0ed6bb46091476d2620ae31cab2-jamesfranco.rsquare.w330_ji1vaf.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (4, 15206, '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660765957/etp5bb0ivqtyokwn8ivc.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (6, 15207, '2022-08-22T12:00:00', 'Let’s Fly Into The Cosmic Death Storm.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836623/voltron-seasons-3-6-dvd-release_rnhohd.jpg');

INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (8, 14201, '2022-09-30T12:00:00', 'Go on a walk with us!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660750512/xxc1pbb8avuzbxw3n0os.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (8, 14202, '2022-08-15T12:00:00', 'Super fun playdate at the park!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660577639/z2qy9virlkkpwehypxcl.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (8, 14203, '2022-08-15T12:00:00', 'Flop needs a nap buddy.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660761609/ssz1fqrza97qtqwrib57.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (8, 14204, '2022-08-22T12:00:00', 'A birthday party for my turtle Pickles!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660786126/upetkwiod7otqipihv4l.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (8, 14205, '2022-09-30T12:00:00', 'Even James Franco needs a friend!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836414/a4f191c0ed6bb46091476d2620ae31cab2-jamesfranco.rsquare.w330_ji1vaf.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (8, 14206, '2022-08-22T12:00:00', 'Join me at my house for snacks and fetch!', 'https://res.cloudinary.com/picklepoints/image/upload/v1660765957/etp5bb0ivqtyokwn8ivc.jpg');
INSERT INTO playdate (host_id, zip_code, date_and_time, details, playdate_photo) VALUES (8, 14207, '2022-08-22T12:00:00', 'Let’s Fly Into The Cosmic Death Storm.', 'https://res.cloudinary.com/picklepoints/image/upload/v1660836623/voltron-seasons-3-6-dvd-release_rnhohd.jpg');




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

INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (8, 5);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (9, 5);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (10, 5);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (11, 5);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (12, 5);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (13, 5);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (14, 5);

INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (15, 3);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (16, 4);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (17, 6);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (18, 7);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (19, 3);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (20, 4);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (21, 6);

INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (22, 8);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (23, 8);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (24, 8);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (25, 8);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (26, 8);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (27, 8);
INSERT INTO pet_playdate (playdate_id, pet_id) VALUES (28, 8);





--MARKER INSERTS--
--Pgh, PA Area
INSERT INTO markers (zip_code, lat, lng) VALUES ('15212', 40.482805, -80.036726);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15202', 40.497452, -80.060345);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15203', 40.429303, -79.972425);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15204', 40.4567689, -80.056286);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15205', 40.441770, -80.087015);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15206', 40.472064, -79.913673);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15207', 40.403418, -79.955328);
INSERT INTO markers (zip_code, lat, lng) VALUES ('15208', 40.450914, -79.902478);

--Cinnci, OH Area
INSERT into markers (zip_code, lat, lng) VALUES ( 45214, 39.11728189999999, -84.530083);
INSERT into markers (zip_code, lat, lng) VALUES ( 45201, 39.1052864197085, -84.537671);
INSERT into markers (zip_code, lat, lng) VALUES ( 45202, 39.1031971, -84.506488);
INSERT into markers (zip_code, lat, lng) VALUES ( 45203, 39.1019553, -84.53532469999999);
INSERT into markers (zip_code, lat, lng) VALUES ( 45204, 39.0930395, -84.56676650000001);
INSERT into markers (zip_code, lat, lng) VALUES ( 45205, 39.1066278, -84.5798623);
INSERT into markers (zip_code, lat, lng) VALUES ( 45206, 39.130628, -84.4828838);
INSERT into markers (zip_code, lat, lng) VALUES ( 45207, 39.1405079, -84.47239);
INSERT into markers (zip_code, lat, lng) VALUES ( 45208, 39.13357329999999, -84.4356468);
INSERT into markers (zip_code, lat, lng) VALUES ( 45209, 39.1511025, -84.42251859999999);
INSERT into markers (zip_code, lat, lng) VALUES ( 45211, 39.1654029, -84.6165146);
INSERT into markers (zip_code, lat, lng) VALUES ( 45212, 39.1629772, -84.4540213);
INSERT into markers (zip_code, lat, lng) VALUES ( 45213, 39.1822152, -84.42251859999999);
INSERT into markers (zip_code, lat, lng) VALUES ( 45215, 39.2414664, -84.46976629999999);
INSERT into markers (zip_code, lat, lng) VALUES ( 45216, 39.2059442, -84.485507);
INSERT into markers (zip_code, lat, lng) VALUES ( 45217, 39.1676821, -84.498621);


--Buffalo, NY Area
INSERT into markers (zip_code, lat, lng) VALUES ( 14201, 42.89676739999999, -78.8863847);
INSERT into markers (zip_code, lat, lng) VALUES ( 14202, 42.8943161, -78.8736493);
INSERT into markers (zip_code, lat, lng) VALUES ( 14203, 42.8667771, -78.8750644);
INSERT into markers (zip_code, lat, lng) VALUES ( 14204, 42.8801089, -78.8637428);
INSERT into markers (zip_code, lat, lng) VALUES ( 14205, 42.88274411970851, -78.87382048029151);
INSERT into markers (zip_code, lat, lng) VALUES ( 14206, 42.8820351, -78.8099472);
INSERT into markers (zip_code, lat, lng) VALUES ( 14207, 42.9486552, -78.90053329999999);
INSERT into markers (zip_code, lat, lng) VALUES ( 14208, 42.9174901, -78.8524199);
INSERT into markers (zip_code, lat, lng) VALUES ( 14209, 42.91379209999999, -78.8637428);
INSERT into markers (zip_code, lat, lng) VALUES ( 14210, 42.8671413, -78.82977009999999);
INSERT into markers (zip_code, lat, lng) VALUES ( 14211, 42.9109033, -78.8099472);
INSERT into markers (zip_code, lat, lng) VALUES ( 14212, 42.8954613, -78.8241068);
INSERT into markers (zip_code, lat, lng) VALUES ( 14213, 42.9165666, -78.8920444);
INSERT into markers (zip_code, lat, lng) VALUES ( 14214, 42.9334868, -78.84392679999999);
INSERT into markers (zip_code, lat, lng) VALUES ( 14215, 42.93975529999999, -78.8099472);
INSERT into markers (zip_code, lat, lng) VALUES ( 14216, 42.9474532, -78.8637428);



COMMIT TRANSACTION;
