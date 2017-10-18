INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('vkordalis@gmail.com', 'vasilis', 'kordalis', '123456', 'ADMIN', '554869');
INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('kaimakamisxris@gmail.com', 'christos', 'kaimakamis', '123457', 'ADMIN', '425896');
INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('anvailas@gmail.com', 'antonis', 'vailas', '123458', 'ADMIN', '325894');
INSERT INTO carRepair.owner (email, first_name, last_name, password, role, vat) VALUES ('thetida@gmail.com', 'thetida', 'tsantaki', '123459', 'ADMIN', '114875');

INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('red', 'vwagen', 'ADS-8547', '2000', 1);
INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('green', 'audi', 'DJH-5874', '2005', 2);
INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('blue', 'mercedes', 'BND-5555', '2014', 3);
INSERT INTO carRepair.vehicle (color, model, plate_number, year, owner_id) VALUES ('magenta', 'ford', 'TVY-5587', '2017', 4);

INSERT INTO carRepair.repair (cost, date_time, operations, stage, type, vehicle_id) VALUES (50, '2017-10-13 15:50:45', 'oils', 'pending', 'small', 1);
INSERT INTO carRepair.repair (cost, date_time, operations, stage, type, vehicle_id) VALUES (80, '2017-10-13 15:50:45', 'filters', 'in_progress', 'small', 2);
INSERT INTO carRepair.repair (cost, date_time, operations, stage, type, vehicle_id) VALUES (90, '2017-10-13 15:50:45', 'filters, oils', 'in_progress', 'big', 3);
INSERT INTO carRepair.repair (cost, date_time, operations, stage, type, vehicle_id) VALUES (100, '2017-10-13 15:50:45', 'engine repair', 'done', 'big', 4);
