package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor;

import java.time.LocalDateTime;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

public record ProfesorResponse (int id, String nombre, String apellido, LocalDateTime createdAt) {

}
