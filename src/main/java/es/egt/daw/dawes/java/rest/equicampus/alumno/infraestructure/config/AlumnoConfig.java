package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.CreateAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.DeleteAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.EditAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.FindAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.CreateAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.DeleteAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.EditAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.FindAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {

   private final AlumnoRepository alumnoRepository;

      @Bean
    public CreateAlumnoUseCase createAlumnoseCase() {
        return new CreateAlumnoUseCase(alumnoRepository);
    }
    @Bean
    public CreateAlumnoService createAlumnoService(){
        return new CreateAlumnoService(createAlumnoseCase());
    }

    @Bean
    public FindAlumnoUseCase findAlumnoUseCase(){
        return new FindAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public FindAlumnoService findAlumnoService(){
        return new FindAlumnoService(findAlumnoUseCase());
    }
    @Bean 

    public EditAlumnoService editAlumnoService(){
        return new EditAlumnoService(editAlumnoUseCase());

    }

    @Bean
    public EditAlumnoUseCase editAlumnoUseCase(){
        return new EditAlumnoUseCase(alumnoRepository);

    }

    @Bean
    public DeleteAlumnoUseCase deleteAlumnoUseCase(){
        return new DeleteAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public DeleteAlumnoService deleteAlumnoService(){
        return new DeleteAlumnoService(deleteAlumnoUseCase());
    }
}
