-- ========================
-- Insert Alumnos
-- ========================
INSERT INTO Alumno (nombre, apellidos) VALUES
('Juan', 'Pérez'),
('Ana', 'López'),
('Luis', 'Martínez'),
('Marta', 'García'),
('Carlos', 'Sánchez'),
('Lucía', 'Fernández'),
('Pedro', 'Gómez'),
('Laura', 'Ramírez'),
('David', 'Hernández'),
('Carmen', 'Jiménez');

-- ========================
-- Insert Profesores
-- ========================
INSERT INTO Profesor (nombre, apellidos) VALUES
('Miguel', 'Torres'),
('Sandra', 'Morales'),
('Javier', 'Ortiz'),
('María', 'Vega'),
('Alberto', 'Santos');

-- ========================
-- Insert Caballos
-- ========================
INSERT INTO Caballo (nombre, edad, raza, alumno_id) VALUES
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
-- Insert Pistas
-- ========================
INSERT INTO Pista (nombre) VALUES
('Pista Norte'),
('Pista Sur'),
('Pista Este'),
('Pista Oeste'),
('Pista Central');

-- ========================
-- Insert Clases
-- ========================
INSERT INTO Clase (nombre, profesor_id, alumno_id, tipo) VALUES
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
-- Insert Reservas
-- ========================
INSERT INTO Reserva (alumno_id, clase_id, pista_id, caballo_id) VALUES
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
