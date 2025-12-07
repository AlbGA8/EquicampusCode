package es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.EditAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.EditAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditAlumnoService {

    private final EditAlumnoUseCase editAlumnoUseCase;

    @CacheEvict(allEntries = true) 
    @CachePut(key = "#command.id") 
    public Alumno update(EditAlumnoCommand comando) {
        Alumno alumno = editAlumnoUseCase.update(comando);
        return alumno;
    }

}
