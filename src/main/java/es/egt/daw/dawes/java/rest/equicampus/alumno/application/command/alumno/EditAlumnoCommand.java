package es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno;


import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditAlumnoCommand {

    private AlumnoId id;
    private String nombre;
    private String apellido;

}
