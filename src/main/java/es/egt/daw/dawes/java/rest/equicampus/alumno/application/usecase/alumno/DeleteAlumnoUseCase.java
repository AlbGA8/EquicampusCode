package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno;



import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;
    public void delete(AlumnoId id) {
        alumnoRepository.deteteById(id);
    }
    

}
