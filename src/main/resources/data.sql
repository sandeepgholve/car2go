-- Populate Data

-- Car Category
INSERT INTO car_category (id, name, rental_value) VALUES (1000, 'smart for two', 10);
INSERT INTO car_category (id, name, rental_value) VALUES (1001, 'A-Class', 15);
INSERT INTO car_category (id, name, rental_value) VALUES (1002, 'B-Class', 20);
INSERT INTO car_category (id, name, rental_value) VALUES (1003, 'CLA', 25);
INSERT INTO car_category (id, name, rental_value) VALUES (1004, 'GLA', 25);

-- Equipment Category
INSERT INTO equipment_category (id, name, rental_value) VALUES (1000, 'child booster seat', 5);
INSERT INTO equipment_category (id, name, rental_value) VALUES (1001, 'cycle carrier', 7);
INSERT INTO equipment_category (id, name, rental_value) VALUES (1002, 'winter tyres', 12);


-- Locations
INSERT INTO location(id, city, country, state, street_address, zip)
VALUES (1000, 'Berlin', 'Germany', 'Berlin', 'Rhinstr. 161', '10315');
INSERT INTO location(id, city, country, state, street_address, zip)
VALUES (1001, 'Hamburg', 'Germany', 'Hamburg', 'Glockengiesserwall 12', '20095');
INSERT INTO location(id, city, country, state, street_address, zip)
VALUES (1002, 'Munich', 'Germany', 'Baveria', 'Prinzregentenstrasse', '80538');

-- Cars
INSERT INTO car(id, brand, color, mileage, model, production_year, car_category_id, current_location_id)
VALUES (1000, 'Audi', 'Black', 12, 'A7 Sprotback', 2015, 1003, 1000);