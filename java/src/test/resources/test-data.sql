BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user1','user1','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user2','user2','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user3','user3','ROLE_USER','email@email.com');

INSERT INTO pets (name, species, sex, birth_date, is_fixed, has_vaccinations, size, user_id) VALUES ('pet1', 'dog', 'male', '2022-01-20', true, true, 2, 1);
INSERT INTO pets (name, species, sex, birth_date, is_fixed, has_vaccinations, size, user_id) VALUES ('pet2', 'dog', 'male', '2022-01-20', true, true, 2, 1);
INSERT INTO pets (name, species, sex, birth_date, is_fixed, has_vaccinations, size, user_id) VALUES ('pet3', 'dog', 'male', '2022-01-20', true, true, 2, 1);



INSERT INTO personality (type) VALUES ('timid');
INSERT INTO personality (type) VALUES ('tires quickly');
INSERT INTO personality (type) VALUES ('independent');


INSERT INTO pet_personality (pet_id, personality_id) VALUES (1, 1);


COMMIT TRANSACTION;
