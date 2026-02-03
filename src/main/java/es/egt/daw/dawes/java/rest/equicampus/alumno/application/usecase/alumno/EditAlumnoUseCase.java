package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;


import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.EditAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error.AlumnoNotFoundException;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@RequiredArgsConstructor
public class EditAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public Alumno update(EditAlumnoCommand command){
        return alumnoRepository.getById(command.id())
        .map(a ->{
            a.setNombre(command.nombre());
            a.setApellido(command.apellido());
            return alumnoRepository.save(a);})
        .orElseThrow(()-> new AlumnoNotFoundException(command.id().getValue()));
    }

}
