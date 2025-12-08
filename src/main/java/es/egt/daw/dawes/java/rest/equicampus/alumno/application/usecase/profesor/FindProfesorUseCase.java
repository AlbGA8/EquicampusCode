package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor;

import java.util.List;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error.AlumnoNotFoundException;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@RequiredArgsConstructor
public class FindProfesorUseCase {
    private final ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        List<Profesor> profesor = profesorRepository.getAll();

        if (profesor.isEmpty())
            throw new AlumnoNotFoundException();

        return profesor;
    }

}
