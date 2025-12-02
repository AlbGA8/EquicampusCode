package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.CreateAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.CreateAlumnoUseCase;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {

      @Bean
    public CreateAlumnoUseCase createAlumnoseCase() {
        return new CreateAlumnoUseCase();
    }
    @Bean
    public CreateAlumnoService createAlumnoService(){
        return new CreateAlumnoService(createAlumnoseCase());
    }

}
