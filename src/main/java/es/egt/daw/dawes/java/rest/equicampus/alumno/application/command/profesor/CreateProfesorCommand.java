package es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor;

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
public class CreateProfesorCommand {

    protected String nombre;
    protected String apellido;
    

}
