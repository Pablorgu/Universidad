DELETE dbo.PLANTILLA
DELETE dbo.SALA
DELETE dbo.HOSPITAL

INSERT INTO dbo.HOSPITAL
VALUES (13, 'Provincial', 'ODonell 50', '964-4264' , 502),
(18, 'General', 'Atocha s/n', '595-3111', 987),
(22,'La Paz', 'Castellana 1000', '923-5411', 412),
(45, 'San Carlos', 'Ciudad Universitaria', '597-1500', 845);

INSERT INTO dbo.SALA
VALUES(13, 3, 'Cuidados Intensivos', 21),
(13, 6, 'Psiquiatrico', 67),
(18, 3, 'Cuidados Intensivos', 10),
(18, 4, 'Cardiologia',53),
(22, 1, 'Recupetacion', 10),
(22, 2, 'Maternidad', 34),
(22, 6, 'Psiquiatrico', 118);


INSERT INTO dbo.PLANTILLA
VALUES (22, 6, 1009, 'Higueras D.', 'Enfermera',  'T', 20050.00),
(22, 2, 1234, 'Garcia J.', 'Enfermo', 'M', 30000.00),
(22, 2, 1280, 'Amigo R.', 'Interno', 'N', 22100.00),
(13, 6, 3106, 'Hernandez J.', 'Enfermero', 'T', 27550.00),
(13, 6, 3754, 'Diaz B.', 'Enfermera', 'T', 22620.00),
(22, 1, 6065, 'Rivera G.', 'Enfermera', 'N', 16260.00),
(18, 4, 6357, 'Karplus W.', 'Interno', 'T', 33790.00),
(22, 1, 7379, 'Carlos R.', 'Enfermera', 'T', 21190.00),
(22, 6, 8422, 'Bocina G.', 'Enfermero', 'M', 16380.00),
(22, 1, 8526, 'Frank H.', 'Enfermera', 'T', 25220.00),
(22, 2 ,9901, 'Nu ez C.', 'Interno', 'M', 22100.00);