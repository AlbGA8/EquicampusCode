package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.FindProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindProfesorService extends ProfesorService{
private final FindProfesorUseCase findProfesorUseCase;
@Cacheable
     public List<Profesor> findAll() {
        return findProfesorUseCase.findAll();
     }
}

