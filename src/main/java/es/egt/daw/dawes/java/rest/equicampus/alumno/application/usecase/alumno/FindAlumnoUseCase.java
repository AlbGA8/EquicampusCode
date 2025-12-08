package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;


import java.util.List;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error.AlumnoNotFoundException;
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
public class FindAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {

        List<Alumno> alumnos = alumnoRepository.getAll();

        if (alumnos.isEmpty())
            throw new AlumnoNotFoundException();

        return alumnos;

    }

}
