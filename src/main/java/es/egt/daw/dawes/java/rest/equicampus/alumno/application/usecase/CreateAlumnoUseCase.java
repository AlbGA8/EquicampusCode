package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase;

import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAlumnoUseCase {

    public Alumno create (CreateAlumnoCommand comando) {
        Alumno alumno = Alumno.builder()

        .nombre(comando.nombre())
        .apellidos(comando.apellido())
        .createdAt(LocalDateTime.now()).build();

        return alumno;
    }

}
