package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;



import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@AllArgsConstructor
public class DeleteAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;
    public void delete(AlumnoId id) {
        alumnoRepository.deteteById(id);
    }
    

}
