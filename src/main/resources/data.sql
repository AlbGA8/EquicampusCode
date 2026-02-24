-- 1. CARGA DE PROFESORES (Deben existir antes que los alumnos)
INSERT  INTO profesor (profesor_id, nombre, apellido, created_at) VALUES
(1, 'Miguel', 'Torres', NOW()),
(2, 'Sandra', 'Morales', NOW()),
(3, 'Javier', 'Ortiz', NOW()),
(4, 'María', 'Vega', NOW()),
(5, 'Alberto', 'Santos', NOW());

-- 2. CARGA DE ALUMNOS
INSERT  INTO alumno (alumno_id, nombre, apellido, email, profesor_id, created_at) VALUES
(1, 'Juan', 'Pérez', 'juan.perez@email.com', 1, NOW()),
(2, 'Ana', 'López', 'ana.lopez@email.com', 2, NOW()),
(3, 'Luis', 'Martínez', 'luis.martinez@email.com', 1, NOW()),
(4, 'Marta', 'García', 'marta.garcia@email.com', 2, NOW()),
(5, 'Carlos', 'Sánchez', 'carlos.sanchez@email.com', 1, NOW()),
(6, 'Lucía', 'Fernández', 'lucia.fernandez@email.com', 2, NOW()),
(7, 'Pedro', 'Gómez', 'pedro.gomez@email.com', 1, NOW()),
(8, 'Laura', 'Ramírez', 'laura.ramirez@email.com', 2, NOW()),
(9, 'David', 'Hernández', 'david.hernandez@email.com', 1, NOW()),
(10, 'Carmen', 'Jiménez', 'carmen.jimenez@email.com', 2, NOW());

-- 3. CARGA DE USUARIOS (Para que puedas hacer login)
INSERT  INTO usuarios (id, firstname, lastname, email, password, role) VALUES 
(1,'user', 'user', 'user@a.com', '$2a$12$PB6GwcJCu44g/T895VObduyyMGsX.Rl/QN0kU/IY0l9HOPokGJBpe', 'USER'),
(2,'admin', 'admin', 'admin@a.com', '$2a$12$crH/Tuxn/3in7inhgLzoiOTfaXm2sLQy5alm0pwlBXu2z./MzwTMW', 'ADMIN');


