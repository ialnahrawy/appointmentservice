/**
 * CREATE Script for init of DB
 */

insert into slot (id,start_time, end_time,Status) values (1, '2018-09-28 16:00:00' , '2018-09-28 16:30:00' , 'BUSY'	);
insert into slot (id,start_time, end_time,Status) values (2, '2018-09-28 17:00:00' , '2018-09-28 16:30:00' , 'BUSY'	);
insert into slot (id,start_time, end_time,Status) values (3, '2018-09-28 18:00:00' , '2018-09-28 16:30:00' , 'BUSY'	);
insert into slot (id,start_time, end_time,Status) values (4, '2018-09-28 19:00:00' , '2018-09-28 16:30:00' , 'BUSY'	);


----
insert into APPOINTMENT_TYPE  (id,name, code,description, comment) values (1, 'CHECKUP' , 'CHECKUP' , 'A routine check-up, such as an annual physical', ''	);
insert into APPOINTMENT_TYPE  (id,name, code,description, comment) values (2, 'EMERGENCY' , 'EMERGENCY	' , 'Emergency appointment', ''	);
insert into APPOINTMENT_TYPE  (id,name, code,description, comment) values (3, 'FOLLOWUP' , 'FOLLOWUP' , 'A follow up visit from a previous appointment', ''	);
insert into APPOINTMENT_TYPE  (id,name, code,description, comment) values (4, 'ROUTINE' , 'ROUTINE' , 'Routine appointment ', ''	);

---

insert into REFERENCE   (id,Summary, reference_url,description, ref_type) values (1, 'RBC results' , '' , 'RBC analysis', 'DOCUMENT'	);
insert into REFERENCE   (id,Summary, reference_url,description, ref_type) values (2, 'Scan Xray' , '' , 'Xray Scan', 'IMAGE'	);
insert into REFERENCE   (id,Summary, reference_url,description, ref_type) values (3, 'CT Scan' , '' , 'CT scan', 'IMAGE'	);
---

insert into APPOINTMENT   (id,doctor_id, patient_id,location_id, remarks, reason,priority,description,status, created_on, slot_id, type_id) values (1, 1 , 1, 1, ' remarsks... ', 'pain', 1, 'i feel headach', 'BOOKED', '2018-09-18 16:10:00', 1, 1	);
insert into APPOINTMENT   (id,doctor_id, patient_id,location_id, remarks, reason,priority,description,status, created_on, slot_id, type_id) values (2, 1 , 2, 1, ' remarsks... ', 'pain', 1, 'i feel headach', 'BOOKED', '2018-09-18 16:10:00', 2, 1	);
insert into APPOINTMENT   (id,doctor_id, patient_id,location_id, remarks, reason,priority,description,status, created_on, slot_id, type_id) values (3, 1 , 3, 1, ' remarsks... ', 'pain', 1, 'i feel headach', 'BOOKED', '2018-09-18 16:10:00', 3, 1	);
insert into APPOINTMENT   (id,doctor_id, patient_id,location_id, remarks, reason,priority,description,status, created_on, slot_id, type_id) values (4, 1 , 4, 1, ' remarsks... ', 'pain', 1, 'i feel headach', 'BOOKED', '2018-09-18 16:10:00', 4, 1	);

----

insert into APPOINTMENT_REFERENCE  (references_id, appointments_id) values (1,1);
insert into APPOINTMENT_REFERENCE  (references_id, appointments_id) values (2,1);
insert into APPOINTMENT_REFERENCE  (references_id, appointments_id) values (3,1);


