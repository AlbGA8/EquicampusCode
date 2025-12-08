package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.CreateProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.CreateProfesorUseCase;
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
public class CreateProfesorService extends ProfesorService {
	private final CreateProfesorUseCase createProfesorUseCase;

	@CacheEvict(allEntries = true)
	public Profesor createProfesor(CreateProfesorCommand command) {

		return createProfesorUseCase.create(command);
	}

}
