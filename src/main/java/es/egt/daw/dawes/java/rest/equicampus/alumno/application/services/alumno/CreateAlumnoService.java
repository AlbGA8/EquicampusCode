package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.CreateAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */
@RequiredArgsConstructor
@Service
public class CreateAlumnoService extends AlumnoService {

    private final CreateAlumnoUseCase createAlumnoUseCase;

    @CacheEvict(allEntries = true) // Elimina de cache la lista
    public Alumno createAlumno(CreateAlumnoCommand command) {

        return createAlumnoUseCase.create(command);
    }

}
