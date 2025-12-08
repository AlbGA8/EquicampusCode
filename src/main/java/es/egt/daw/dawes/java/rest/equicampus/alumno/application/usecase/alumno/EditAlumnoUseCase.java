package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;


import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.EditAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error.AlumnoNotFoundException;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public Alumno update(EditAlumnoCommand command){
        return alumnoRepository.getById(command.id())
        .map(a ->{
            a.setNombre(command.nombre());
            a.setApellidos(command.apellido());
            return alumnoRepository.save(a);})
        .orElseThrow(()-> new AlumnoNotFoundException(command.id().getValue()));
    }

}
