package es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor;


import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.CreateProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProfesorUseCase {

    private final ProfesorRepository profesorRepository;
    public Profesor create(CreateProfesorCommand command){
        Profesor profesor = Profesor.builder()

        .nombre(command.nombre())
        .apellidos(command.apellido())
        .createdAt(LocalDateTime.now()).build();
        
        
        return profesorRepository.save(profesor);
    }

}
