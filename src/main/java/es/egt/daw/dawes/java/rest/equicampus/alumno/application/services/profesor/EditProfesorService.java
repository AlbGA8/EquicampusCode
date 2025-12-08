package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.EditProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.EditProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Service
@RequiredArgsConstructor
public class EditProfesorService extends ProfesorService {

    private final EditProfesorUseCase EditProfesorUsecase;

    @CacheEvict(allEntries = true)
    @CachePut(key = "#command.id")
    public Profesor update(EditProfesorCommand command) {

        return EditProfesorUsecase.update(command);
    }
}
