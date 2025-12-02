package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno;

import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.DeleteAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteAlumnoService {
    private final DeleteAlumnoUseCase deleteAlumnoUseCase;

    public void delete(AlumnoId id){
        deleteAlumnoUseCase.delete(id);
    }


}
