-- Sample values
INSERT INTO UNIT (NAME, ABBREVIATION) VALUES ('grams','g')
INSERT INTO UNIT (NAME, ABBREVIATION) VALUES ('kilograms','kg')
INSERT INTO UNIT (NAME, ABBREVIATION) VALUES ('liters','l')
INSERT INTO UNIT (NAME, ABBREVIATION) VALUES ('mililiters','ml')
INSERT INTO COMPONENT (UNITID,NAME) VALUES ((SELECT id from unit WHERE abbreviation = 'g'),'sugar')
INSERT INTO COMPONENT (UNITID,NAME) VALUES ((SELECT id from unit WHERE abbreviation = 'kg'),'potatoes')
INSERT INTO COMPONENT (UNITID,NAME) VALUES ((SELECT id from unit WHERE abbreviation = 'l'),'water')
INSERT INTO COMPONENT (UNITID,NAME) VALUES ((SELECT id from unit WHERE abbreviation = 'ml'),'shampoo')
INSERT INTO COMPONENT (UNITID,NAME) VALUES ((SELECT id from unit WHERE abbreviation = 'g'),'coffee')
INSERT INTO PRODUCT (NAME,DESCRIPTION) VALUES ('coffe','a cup')
INSERT INTO ASSEMBLY (COMPONENTID,PRODUCTID,QUANTITY) VALUES ((SELECT id from component WHERE name = 'sugar'),(SELECT id from product WHERE name = 'coffe'),4.0)
INSERT INTO ASSEMBLY (COMPONENTID,PRODUCTID,QUANTITY) VALUES ((SELECT id from component WHERE name = 'coffee'),(SELECT id from product WHERE name = 'coffe'),8.3);
