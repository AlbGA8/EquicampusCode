package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.profesor.NombradoProfesor;
import jakarta.validation.constraints.NotBlank;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

public record ProfesorRequest(
        @NotBlank(message = "{profesor.valid.nombre.no_vacio}") @NombradoProfesor(message = "{profesor.valid.nombre.nombrado_validation}") String nombre,
        @NotBlank(message = "{profesor.valid.apellido.no_vacio}") @NombradoProfesor(message = "{profesor.valid.apellido.nombrado_validation}") String apellido) {

    // Constructor desde la entidad Profesor
    public ProfesorRequest(Profesor profesor) {
        this(profesor.getNombre(), profesor.getApellido());
    }
}
