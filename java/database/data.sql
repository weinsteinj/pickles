BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('A','B','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('admin','admin','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','admin@admin.com');

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
VALUES ('Junebug', 'dog', 'female', '2015-06-10', true, true, 'small');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('Kona', 'dog', 'female', '2017-04-15', true, true, 'small');

INSERT INTO pets(name, species, sex, birth_date, is_fixed, has_vaccinations, size)
VALUES ('James Franco', 'dog', 'male', '2013-08-15', true, true, 'large');


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



COMMIT TRANSACTION;
