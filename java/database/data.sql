BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('A','B','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('admin','admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','admin@admin.com');

COMMIT TRANSACTION;
--
----PET INSERTS--
--
--INSERT INTO pets(name, species, sex, birth_date, personality, is_fixed, has_vaccinations, size)
--VALUES ('Junebug', 'dog', 'female', '2015-06-10', 'Loving and excitable but calms down quickly. June loves to be chased and loves to try to eat bees. She is not a fan of wrestling and does not like to be bullied.', true, true, 'small');
--
--INSERT INTO pets(name, species, sex, birth_date, personality, is_fixed, has_vaccinations, size)
--VALUES ('Kona', 'dog', 'female', '2017-04-15', 'Kona is a total sweetheart and gets along with most breeds. She loves all type of play but is slightly territorial with chew toys', true, true, 'small');
--
--INSERT INTO pets(name, species, sex, birth_date, personality, is_fixed, has_vaccinations, size)
--VALUES ('James Franco', 'dog', 'male', '2013-08-15', 'High-energy. Always loves a good chase and tummy rub. Very social - almost too co-dependent.', true, true, 'large');
--
----USER INSERTS--
--INSERT INTO users(first_name, last_name, username, role, email_address, address, birth_date)
--VALUES ('Caito', 'Nagelson', 'c80_grace', 'role_user', 'cnagelson@gmail.com', '2305 Carrie St, Pittsburgh PA, 15212', '1987-10-20');
--
--INSERT INTO users(first_name, last_name, username, role, email_address, address, birth_date)
--VALUES ('Bradley', 'Mauger', 'bmauger', 'role_admin', 'bradleyamauger@gmail.com', '1917 Fairmount Avenue, Cincinnati OH, 45214', '03/10/1988');
--
----USER/PET INSERTS--
--INSERT INTO user_pet (user_id, pet_id)
--VALUES ((SELECT user_id FROM users WHERE first_name = 'Caito'), (SELECT pet_id from pets WHERE name = 'Junebug'));
--
--INSERT INTO user_pet (user_id, pet_id)
--VALUES ((SELECT user_id FROM users WHERE first_name = 'Caito'), (SELECT pet_id from pets WHERE name = 'Kona'));
--
--INSERT INTO user_pet (user_id, pet_id)
--VALUES ((SELECT user_id FROM users WHERE first_name = 'Bradley'), (SELECT pet_id from pets WHERE name = 'James Franco'));
