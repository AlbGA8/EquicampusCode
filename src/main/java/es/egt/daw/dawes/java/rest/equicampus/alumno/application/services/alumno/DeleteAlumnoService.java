package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.DeleteAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */
@RequiredArgsConstructor
@Service
public class DeleteAlumnoService extends AlumnoService {
    private final DeleteAlumnoUseCase deleteAlumnoUseCase;

    @CacheEvict(allEntries = true) // Elimina de cache la lista
    public void delete(AlumnoId id) {
        deleteAlumnoUseCase.delete(id);
    }

}
