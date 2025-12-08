package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity;


import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.CaballoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ClaseId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.PistaId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ReservaId;
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
@AllArgsConstructor
@Builder
public class Reserva {

    private ReservaId reservaId;
    private AlumnoId alumnoId;
    private ClaseId claseId;
    private PistaId pistaId;
    private CaballoId caballoId;
    private LocalDateTime createdAt;

}
