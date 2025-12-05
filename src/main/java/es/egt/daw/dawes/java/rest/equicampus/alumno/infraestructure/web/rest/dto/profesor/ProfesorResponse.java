package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor;

import java.time.LocalDateTime;

public record ProfesorResponse (int id, String nombre, String apellido, LocalDateTime createdAt) {

}
