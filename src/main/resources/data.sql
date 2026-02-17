
/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */
 

-- ========================
-- Insert PROFESOR 
-- ========================
INSERT INTO PROFESOR (profesor_id, nombre, apellido) VALUES
(1, 'Miguel', 'Torres'),
(2, 'Sandra', 'Morales'),
(3, 'Javier', 'Ortiz'),
(4, 'María', 'Vega'),
(5, 'Alberto', 'Santos');

INSERT INTO ALUMNO (nombre, apellido, email, profesor_id) VALUES
('Juan', 'Pérez', 'juan.perez@email.com', 1),
('Ana', 'López', 'ana.lopez@email.com', 2),
('Luis', 'Martínez', 'luis.martinez@email.com', 1),
('Marta', 'García', 'marta.garcia@email.com', 2),
('Carlos', 'Sánchez', 'carlos.sanchez@email.com', 1),
('Lucía', 'Fernández', 'lucia.fernandez@email.com', 2),
('Pedro', 'Gómez', 'pedro.gomez@email.com', 1),
('Laura', 'Ramírez', 'laura.ramirez@email.com', 2),
('David', 'Hernández', 'david.hernandez@email.com', 1),
('Carmen', 'Jiménez', 'carmen.jimenez@email.com', 2);



-- ========================
-- Insert CABALLO
-- ========================
INSERT INTO CABALLO (nombre, edad, raza, alumno_id) VALUES
('Viento', 5, 'Pura Sangre', 1),
('Relámpago', 7, 'Árabe', 2),
('Trueno', 4, 'Andaluz', 3),
('Rayo', 6, 'Frisón', 4),
('Estrella', 3, 'Lusitano', 5),
('Nube', 5, 'Árabe', 6),
('Centella', 4, 'Pura Sangre', 7),
('Furia', 6, 'Andaluz', 8),
('Brisa', 3, 'Lusitano', 9),
('Sombra', 7, 'Frisón', 10);

-- ========================
-- Insert PISTA
-- ========================
INSERT INTO PISTA (nombre) VALUES
('Pista Norte'),
('Pista Sur'),
('Pista Este'),
('Pista Oeste'),
('Pista Central');

-- ========================
-- Insert CLASE
-- ========================
INSERT INTO CLASE (nombre, profesor_id, alumno_id, tipo) VALUES
('Clase Básica 1', 1, 1, 'PRACTICA'),
('Clase Básica 2', 2, 2, 'PRACTICA'),
('Clase Teórica 1', 3, 3, 'TEORICA'),
('Clase Teórica 2', 4, 4, 'TEORICA'),
('Clase Avanzada 1', 5, 5, 'PRACTICA'),
('Clase Avanzada 2', 1, 6, 'TEORICA'),
('Clase Intermedia 1', 2, 7, 'PRACTICA'),
('Clase Intermedia 2', 3, 8, 'TEORICA'),
('Clase Final 1', 4, 9, 'PRACTICA'),
('Clase Final 2', 5, 10, 'TEORICA');

-- ========================
-- Insert RESERVA
-- ========================
INSERT INTO RESERVA (alumno_id, clase_id, pista_id, caballo_id) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2),
(3, 3, 3, 3),
(4, 4, 4, 4),
(5, 5, 5, 5),
(6, 6, 1, 6),
(7, 7, 2, 7),
(8, 8, 3, 8),
(9, 9, 4, 9),
(10, 10, 5, 10);

-- ========================
-- Insert ROLES USUARIOS
-- ========================
INSERT INTO USUARIOS (id, firstname, lastname, email, password, role ) VALUES 
(1,'user', 'user', 'user@a.com', '$2a$12$PB6GwcJCu44g/T895VObduyyMGsX.Rl/QN0kU/IY0l9HOPokGJBpe', 'USER'),
(2,'admin', 'admin', 'admin@a.com', '$2a$12$crH/Tuxn/3in7inhgLzoiOTfaXm2sLQy5alm0pwlBXu2z./MzwTMW', 'ADMIN');

