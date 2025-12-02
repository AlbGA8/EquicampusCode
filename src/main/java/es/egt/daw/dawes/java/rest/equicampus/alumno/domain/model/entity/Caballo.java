package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity;

import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.CaballoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Caballo {

    private String nombre;
    private int edad;
    private CaballoId caballoId;
    private String raza;
    private AlumnoId alumnoId;
    private LocalDateTime createdAt;
}
