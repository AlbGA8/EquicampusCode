package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.CreateAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateAlumnoService extends AlumnoService {

    private final CreateAlumnoUseCase createAlumnoUseCase;

    @CacheEvict(allEntries = true) // Elimina de cache la lista
    public Alumno createAlumno(CreateAlumnoCommand comando) {

        Alumno alumno = createAlumnoUseCase.create(comando);
        return alumno;
    }

}
