package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity;

import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class Alumno {
    private String nombre;
    private String apellidos;
    private AlumnoId alumnoId;
    private LocalDateTime createdAt;
   

}
