INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('vkordalis@gmail.com', 'vasilis', 'kordalis', '123456', 'ADMIN', '554869');
INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('kaimakamisxris@gmail.com', 'christos', 'kaimakamis', '123457', 'ADMIN', '425896');
INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('anvailas@gmail.com', 'antonis', 'vailas', '123458', 'ADMIN', '325894');
INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('thetida@gmail.com', 'thetida', 'tsantaki', '123459', 'USER', '1');

INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('red', 'vwagen', 'AEH-8547', '2000', 1);
INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('green', 'audi', 'IKA-5874', '2005', 2);
INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('blue', 'mercedes', 'YHT-5555', '2014', 3);
INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('magenta', 'ford', 'ITA-5587', '2017', 4);

INSERT INTO carRepair.repair (cost, date_time, stage, type, vehicle_id) VALUES (50, '2017-10-28 15:50:45', 'PENDING', 'SMALL', 1);
INSERT INTO carRepair.repair (cost, date_time, stage, type, vehicle_id) VALUES (80, '2017-10-29 15:50:45', 'IN_PROGRESS', 'SMALL', 2);
INSERT INTO carRepair.repair (cost, date_time, stage, type, vehicle_id) VALUES (90, '2017-10-30 15:50:45', 'IN_PROGRESS', 'BIG', 4);
INSERT INTO carRepair.repair (cost, date_time, stage, type, vehicle_id) VALUES (100, '2017-11-02 15:50:45', 'DONE', 'BIG', 4);
