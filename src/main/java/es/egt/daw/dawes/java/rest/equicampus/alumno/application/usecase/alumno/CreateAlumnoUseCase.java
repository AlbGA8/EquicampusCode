package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;

import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;


/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */


@AllArgsConstructor
public class CreateAlumnoUseCase {
    private final AlumnoRepository alumnoRepository;
    public Alumno create (CreateAlumnoCommand command) {
        Alumno alumno = Alumno.builder()

        .nombre(command.nombre())
        .apellido(command.apellido())
        .createdAt(LocalDateTime.now())
        .profesor(command.ProfesorId())
        .email(command.email()).build();
        

        

        return alumnoRepository.save(alumno);
    }

}
