--Crea usuario
create user usr_dev_apps with encrypted password 'thisIsAHardPassword';
--Crea BD con usuario owner
create database devapps with owner = usr_dev_apps encoding = 'utf8';

INSERT INTO operator (character,precedence) VALUES ('+',1);
INSERT INTO operator (character,precedence) VALUES ('-',1);
INSERT INTO operator (character,precedence) VALUES ('*',2);
INSERT INTO operator (character,precedence) VALUES ('/',2);

INSERT INTO valid_character(character) VALUES ('0');
INSERT INTO valid_character(character) VALUES ('1');
INSERT INTO valid_character(character) VALUES ('2');
INSERT INTO valid_character(character) VALUES ('3');
INSERT INTO valid_character(character) VALUES ('4');
INSERT INTO valid_character(character) VALUES ('5');
INSERT INTO valid_character(character) VALUES ('6');
INSERT INTO valid_character(character) VALUES ('7');
INSERT INTO valid_character(character) VALUES ('8');
INSERT INTO valid_character(character) VALUES ('9');
INSERT INTO valid_character(character) VALUES ('.');
INSERT INTO valid_character(character) VALUES ('+');
INSERT INTO valid_character(character) VALUES ('-');
INSERT INTO valid_character(character) VALUES ('*');
INSERT INTO valid_character(character) VALUES ('/');