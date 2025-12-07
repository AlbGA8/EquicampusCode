package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.FindAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAlumnoService extends AlumnoService {

    private final FindAlumnoUseCase findAlumnoUseCase;
    @Cacheable
    public List<Alumno> findAll() {
        return findAlumnoUseCase.finAll();
    }

}
