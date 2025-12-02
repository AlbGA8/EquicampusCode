package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity;


import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.PistaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Pista {

    private String nombre;
    private PistaId pistaId;
    private LocalDateTime createdAt;
}
