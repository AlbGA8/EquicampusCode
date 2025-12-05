package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.DeleteProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProfesorService {
  private final DeleteProfesorUseCase deleteProfesorUseCase;

    public void delete(ProfesorId id) {

        deleteProfesorUseCase.delete(id);
        
    }
}
