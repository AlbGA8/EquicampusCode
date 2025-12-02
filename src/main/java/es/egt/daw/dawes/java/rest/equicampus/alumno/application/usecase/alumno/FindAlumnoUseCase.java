package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;


import java.util.List;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error.AlumnoNotFoundException;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class FindAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public List<Alumno> finAll() {

        List<Alumno> alumnos = alumnoRepository.getAll();

        if (alumnos.isEmpty())
            throw new AlumnoNotFoundException();

        return alumnos;

    }

}
