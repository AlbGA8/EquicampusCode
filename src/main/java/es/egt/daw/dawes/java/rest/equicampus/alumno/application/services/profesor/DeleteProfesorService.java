package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor;

import org.springframework.cache.annotation.CacheEvict;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.DeleteProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProfesorService extends ProfesorService {
  private final DeleteProfesorUseCase deleteProfesorUseCase;

  @CacheEvict(allEntries = true)
  public void delete(ProfesorId id) {

    deleteProfesorUseCase.delete(id);

  }
}
