-- ========================
-- Tabla Alumno
-- ========================
CREATE TABLE Alumno (
    alumno_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    profesor_id BIGINT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (profesor_id) REFERENCES Profesor(profesor_id) ON DELETE SET NULL
);

-- ========================
-- Tabla Profesor
-- ========================
CREATE TABLE Profesor (
    profesor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ========================
-- Tabla Caballo
-- ========================
CREATE TABLE Caballo (
    caballo_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT,
    raza VARCHAR(50),
    alumno_id BIGINT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(alumno_id) ON DELETE SET NULL
);

-- ========================
-- Tabla Pista
-- ========================
CREATE TABLE Pista (
    pista_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ========================
-- Tabla Clase
-- ========================
CREATE TABLE Clase (
    clase_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    profesor_id BIGINT,
    alumno_id BIGINT,
    tipo ENUM('PRACTICA','TEORICA') NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (profesor_id) REFERENCES Profesor(profesor_id) ON DELETE SET NULL,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(alumno_id) ON DELETE SET NULL
);

-- ========================
-- Tabla Reserva
-- ========================
CREATE TABLE Reserva (
    reserva_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    alumno_id BIGINT NOT NULL,
    clase_id BIGINT NOT NULL,
    pista_id BIGINT NOT NULL,
    caballo_id BIGINT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(alumno_id) ON DELETE CASCADE,
    FOREIGN KEY (clase_id) REFERENCES Clase(clase_id) ON DELETE CASCADE,
    FOREIGN KEY (pista_id) REFERENCES Pista(pista_id) ON DELETE CASCADE,
    FOREIGN KEY (caballo_id) REFERENCES Caballo(caballo_id) ON DELETE CASCADE
);
