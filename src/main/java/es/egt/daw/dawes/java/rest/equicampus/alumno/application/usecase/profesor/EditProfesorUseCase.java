package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.EditProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error.AlumnoNotFoundException;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditProfesorUseCase {
    private final ProfesorRepository profesorRepository;

    public Profesor update(EditProfesorCommand command) {
        return profesorRepository.getById(command.id())
                .map(p -> { // Actualizamos los atributos del objeto
                    p.setNombre(command.nombre());
                    p.setApellidos(command.apellido());
                    return profesorRepository.save(p);
                })
                .orElseThrow(() -> new AlumnoNotFoundException(command.id().getValue())); // Lo cambiamos

    }

}
