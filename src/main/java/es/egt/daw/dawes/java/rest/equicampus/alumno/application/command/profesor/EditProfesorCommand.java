package es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor;


import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditProfesorCommand {

    private ProfesorId id;
    private String nombre;
    private String apellido;

   

}
