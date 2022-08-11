BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user1','user1','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user2','user2','ROLE_USER','email@email.com');
INSERT INTO users (first_name,last_name,username,password_hash,role,email_address) VALUES ('a','b','user3','user3','ROLE_USER','email@email.com');

INSERT INTO pet (name, species, sex, birthday, is_fixed, is_vaccinated, size, user_id) VALUES ('pet1', 'dog', 'male', '2022-01-20', true, true, 2, 1);
INSERT INTO pet (name, species, sex, birthday, is_fixed, is_vaccinated, size, user_id) VALUES ('pet2', 'dog', 'male', '2022-01-20', true, true, 2, 1);
INSERT INTO pet (name, species, sex, birthday, is_fixed, is_vaccinated, size, user_id) VALUES ('pet3', 'dog', 'male', '2022-01-20', true, true, 2, 1);


COMMIT TRANSACTION;
