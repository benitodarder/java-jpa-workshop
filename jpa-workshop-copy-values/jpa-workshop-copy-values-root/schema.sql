-- Schema
CREATE TABLE MASTER (
	id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
	name varchar(64),
	enabled BOOLEAN DEFAULT TRUE NOT NULL,
	value01 DOUBLE,
	value02 VARCHAR(64),
	value03 DOUBLE
)
CREATE TABLE SECONDARY (
	id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
	name varchar(64),
	enabled BOOLEAN DEFAULT TRUE NOT NULL,
	value02 VARCHAR(64),
	value03 DOUBLE,
	masterId INT,
	FOREIGN KEY(masterId) REFERENCES MASTER(id) -- n to 1
)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 01', 69, 'Meh..', 666)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 02', 13, 'Whatever..', 73)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 03', 42, 'Braaainnsss..', 128)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 04', 0, 'Oida', 69)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 05', 3, 'Meh..', 23);