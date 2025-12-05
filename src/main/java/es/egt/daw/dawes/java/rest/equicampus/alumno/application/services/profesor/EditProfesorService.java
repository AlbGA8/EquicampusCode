package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor;

import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.EditProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.EditProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditProfesorService {
    
    private final EditProfesorUseCase EditProfesorUsecase;

    public Profesor update(EditProfesorCommand comando){
        Profesor profesor = EditProfesorUsecase.update(comando);
        return profesor;
    }
}
