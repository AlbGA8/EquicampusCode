package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity;

import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class Alumno {
    private AlumnoId alumnoId;
    private String nombre;
    private String apellidos;
    private LocalDateTime createdAt;
    private ProfesorId profesor;// Relación con Profesor

}
