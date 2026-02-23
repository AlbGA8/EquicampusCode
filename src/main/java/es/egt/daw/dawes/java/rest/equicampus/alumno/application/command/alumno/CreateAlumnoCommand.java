package es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno;


import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */
public class CreateAlumnoCommand {

    private String nombre;
    private String apellido;
    private ProfesorId ProfesorId;
    private String email;

}
