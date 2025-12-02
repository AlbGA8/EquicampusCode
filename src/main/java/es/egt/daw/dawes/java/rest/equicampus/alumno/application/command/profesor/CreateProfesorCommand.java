package es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateProfesorCommand {

    protected String nombre;
    protected String apellido;

}
