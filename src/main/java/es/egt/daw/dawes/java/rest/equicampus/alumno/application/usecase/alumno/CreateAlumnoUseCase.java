package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;

import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class CreateAlumnoUseCase {
    private final AlumnoRepository alumnoRepository;
    public Alumno create (CreateAlumnoCommand comando) {
        Alumno alumno = Alumno.builder()

        .nombre(comando.nombre())
        .apellidos(comando.apellido())
        .createdAt(LocalDateTime.now())
        .profesor(comando.ProfesorId()).build();
        

        alumnoRepository.save(alumno);

        return alumno;
    }

}
