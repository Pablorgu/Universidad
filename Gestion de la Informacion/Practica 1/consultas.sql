SELECT APELLIDOS_NOMBRE
FROM dbo.PLANTILLA
WHERE APELLIDOS_NOMBRE LIKE 'H%';

SELECT APELLIDOS_NOMBRE
FROM dbo.PLANTILLA
WHERE FUNCION = 'Enfermero' OR FUNCION = 'Enfermera'
 AND (TURNO = 'T' OR TURNO = 'M');

 SELECT APELLIDOS_NOMBRE, SALARIO
FROM dbo.PLANTILLA
WHERE FUNCION IN ('Enfermera', 'Enfermero') 
  AND SALARIO BETWEEN 20000 AND 25000;

 SELECT 
LEFT(NOMBRE, 3) AS ABR,
  HOSPITAL_COD,
  NOMBRE AS NOMBRE_COMPLETO
FROM dbo.HOSPITAL
ORDER BY ABR;

SELECT 
  APELLIDOS_NOMBRE,
  SALARIO/12 AS SALARIO_MENSUAL
FROM dbo.PLANTILLA
WHERE FUNCION IN ('Enfermera', 'Enfermero');

SELECT 
  AVG(SALARIO) AS SALARIO_MEDIO
FROM dbo.PLANTILLA
WHERE FUNCION IN ('Enfermera', 'Enfermero');

SELECT 
  MAX(SALARIO) AS SALARIO_MAXIMO,
  MIN(SALARIO) AS SALARIO_MINIMO,
  MAX(SALARIO) - MIN(SALARIO) AS DIFERENCIA
FROM dbo.PLANTILLA;

SELECT 
  FUNCION AS PUESTO,
  AVG(SALARIO) AS SALARIO_MEDIO
FROM dbo.PLANTILLA
GROUP BY FUNCION;

SELECT 
  FUNCION,
  COUNT(*) AS NumeroEmpleados
FROM dbo.PLANTILLA
GROUP BY FUNCION;

SELECT DISTINCT
  H.NOMBRE AS NombreHospital,
  S.NOMBRE AS NombreSala,
  P.FUNCION,
  P.APELLIDOS_NOMBRE AS NombreTrabajador
FROM dbo.PLANTILLA P
JOIN dbo.HOSPITAL H ON P.HOSPITAL_COD = H.HOSPITAL_COD
JOIN dbo.SALA S ON P.SALA_COD = S.SALA_COD
ORDER BY 
  NombreHospital,
  NombreSala,
  FUNCION,
  NombreTrabajador;

  UPDATE dbo.PLANTILLA
SET FUNCION = 'Enfermero'
WHERE UPPER(FUNCION) = 'ENFERMO';

SELECT *
FROM dbo.PLANTILLA;


UPDATE dbo.HOSPITAL
SET NUM_CAMA = NUM_CAMA * 1.1;

SELECT *
FROM dbo.HOSPITAL;
