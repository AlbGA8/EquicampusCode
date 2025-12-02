package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno;

import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.CreateAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateAlumnoService {

    private final CreateAlumnoUseCase createAlumnoUseCase;

    public Alumno createAlumno(CreateAlumnoCommand comando){

        Alumno alumno = createAlumnoUseCase.create(comando);
        return alumno;
    }

}
