package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;

import jakarta.validation.constraints.NotBlank;

public record ProfesorRequest(
        @NotBlank(message = "{profesor.valid.nombre.no_vacio}")
        String nombre,

        @NotBlank(message = "{profesor.valid.apellidos.no_vacio}")
        String apellido
) {

    // Constructor desde la entidad Profesor
    public ProfesorRequest(Profesor profesor) {
        this(profesor.getNombre(), profesor.getApellidos());
    }
}

