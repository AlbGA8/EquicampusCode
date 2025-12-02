package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto;

import java.time.LocalDateTime;

public record AlumnoResponse(int id, String nombre, String apellido, LocalDateTime createdAt) {

}
