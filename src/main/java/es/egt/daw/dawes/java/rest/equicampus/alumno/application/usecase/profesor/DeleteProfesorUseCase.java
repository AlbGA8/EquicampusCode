package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor;


import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;
import lombok.AllArgsConstructor;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@AllArgsConstructor
public class DeleteProfesorUseCase {

    private final ProfesorRepository profesorRepository;
    public void delete(ProfesorId id) {
        profesorRepository.deteteById(id);
    }

}
