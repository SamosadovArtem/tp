INSERT INTO CITY (title) VALUES ('Mogilev');
INSERT INTO CITY (title) VALUES ('Minsk');
INSERT INTO CITY (title) VALUES ('Vitebsk');
INSERT INTO CITY (title) VALUES ('Gomel');
INSERT INTO CITY (title) VALUES ('Brest');

INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("Admin", "$2a$10$N1qLaE9c4.YhH6gUF3iNfu1HwAouKiM7fcWSqhVsMqp9KvnWN.CIi", "Admin@Admin.A", 1, "admin", "100");
INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("Artem", "Samosadov", "pizzaeueu@gmail.com", 2, "123qwe", "100");
INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("Vitya", "Yellow", "Vitya99@mail.ru", 2, "vitya99", "100");
INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("Vasia", "Carrynni", "Vasia@ya.ru", 3, "tYrr@3", "100");
INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("Elena", "Prolova", "LenkaProl_24@mail.ru", 4, "123123", "100");
INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("Misha", "Sobol", "Sobol@hotmail.com", 5, "_34fe", "100");
INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("Test", "Test", "Test@Test.Test", 5, "Test", "100");
INSERT INTO USER (name, password, email, city, money_account, balance) VALUES ("123", "$2a$10$bEdxLNBJaY9sgXjkgV56e.tmGDUKHoeW5ncdfy1jsCgEOVUhR4kWu", "123@123.123", 5, "123", "100");

INSERT INTO ROLE (title) VALUES ("ROLE_USER");
INSERT INTO ROLE (title) VALUES ("ROLE_ADMIN");

INSERT INTO user_role (role_id, user_id) VALUES (2, 1);
INSERT INTO user_role (role_id, user_id) VALUES (2, 2);
INSERT INTO user_role (role_id, user_id) VALUES (2, 3);
INSERT INTO user_role (role_id, user_id) VALUES (2, 4);
INSERT INTO user_role (role_id, user_id) VALUES (2, 5);
INSERT INTO user_role (role_id, user_id) VALUES (2, 6);
INSERT INTO user_role (role_id, user_id) VALUES (2, 7);
INSERT INTO user_role (role_id, user_id) VALUES (1, 8);

INSERT INTO PLACE (title, city, street, building_number, description) VALUES ("Puskin place", 1, "Puskin avenue", 4, "Good place");
INSERT INTO PLACE (title, city, street, building_number, description) VALUES ("Grand Place", 2, "Lenin street", 19, "Perfect place");
INSERT INTO PLACE (title, city, street, building_number, description) VALUES ("Dream Cinema", 3, "Center street", 25, "Good place");
INSERT INTO PLACE (title, city, street, building_number, description) VALUES ("Main Theater", 4, "Main Street", 45, "Main place");
INSERT INTO PLACE (title, city, street, building_number, description) VALUES ("Test place", 5, "Test avenue", 0, "Test place");

INSERT INTO Event_Type (type) VALUES ("Cinema");
INSERT INTO Event_Type (type) VALUES ("Theater");
INSERT INTO Event_Type (type) VALUES ("Concert");
INSERT INTO Event_Type (type) VALUES ("Sport");
INSERT INTO Event_Type (type) VALUES ("Travel");

INSERT INTO EVENT (title, description, event_type_id, confirmed, place) VALUES ("Event1", "Some event", 1, TRUE, 1);
INSERT INTO EVENT (title, description, event_type_id, confirmed, place) VALUES ("Band Concert", "music", 3, TRUE, 2);
INSERT INTO EVENT (title, description, event_type_id, confirmed, place) VALUES ("New Cinema", "cinema", 1, TRUE, 3);
INSERT INTO EVENT (title, description, event_type_id, confirmed, place) VALUES ("New Perfomance", "theater", 2, TRUE, 4);
INSERT INTO EVENT (title, description, event_type_id, confirmed, place) VALUES ("Car race", "sport", 4, TRUE, 5);
INSERT INTO EVENT (title, description, event_type_id, confirmed, place) VALUES ("Train ticke", "buy it and run", 5, TRUE, 2);
INSERT INTO EVENT (title, description, event_type_id, confirmed, place) VALUES ("PRANK", "it's a prank", 1, FALSE, 1);

INSERT INTO COMMENT (event, user, text, comment_date) VALUES (1, "Vitya", "Love this", "10.10.2016");
INSERT INTO COMMENT (event, user, text, comment_date) VALUES (2, "Elena", "Oh! Cool!", "10.10.2016");
INSERT INTO COMMENT (event, user, text, comment_date) VALUES (3, "Vitya", "wtf?", "10.10.2016");
INSERT INTO COMMENT (event, user, text, comment_date) VALUES (4, "Elena", "Yeah, great band", "10.10.2016");
INSERT INTO COMMENT (event, user, text, comment_date) VALUES (5, "123", "Soon!", "10.10.2016");

INSERT INTO TICKET (buyer, cost, event_id, seller) VALUES (1, 15, 2, 3);
INSERT INTO TICKET (buyer, cost, event_id, seller) VALUES (2, 17, 3, 4);
INSERT INTO TICKET (buyer, cost, event_id, seller) VALUES (NULL, 3, 3, 3);
INSERT INTO TICKET (buyer, cost, event_id, seller) VALUES (4, 20, 4, 3);
INSERT INTO TICKET (buyer, cost, event_id, seller) VALUES (5, 12, 2, 3);

