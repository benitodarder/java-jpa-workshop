-- Sample values
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 01', 69, 'Meh..', 666)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 02', 13, 'Whatever..', 73)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 03', 42, 'Braaainnsss..', 128)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 04', 0, 'Oida', 69)
INSERT INTO MASTER (NAME, VALUE01, VALUE02, VALUE03) VALUES ('Primary 05', 3, 'Meh..', 23)
INSERT INTO BASE (NAME, COMMONVALUE) VALUES ('Base 01', 'Meh..')
INSERT INTO BASE (NAME, COMMONVALUE) VALUES ('Base 02', 'Pfff..')
INSERT INTO BASE (NAME, COMMONVALUE) VALUES ('Base 03', 'Whatever..')
INSERT INTO MASTER_FROM_BASE (id, NAME, VALUE01, VALUE02, VALUE03) VALUES ((select id from base where name = 'Base 01'), 'Primary 01', 69, 'Meh..', 666)
INSERT INTO MASTER_FROM_BASE (id, NAME, VALUE01, VALUE02, VALUE03) VALUES ((select id from base where name = 'Base 02'), 'Primary 02', 13, 'Whatever..', 73)
INSERT INTO MASTER_FROM_BASE (id, NAME, VALUE01, VALUE02, VALUE03) VALUES ((select id from base where name = 'Base 03'), 'Primary 03', 42, 'Braaainnsss..', 128);
