package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity;


import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.PistaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Data
@Builder
@AllArgsConstructor

public class Pista {

    private String nombre;
    private PistaId pistaId;
    private LocalDateTime createdAt;
}
