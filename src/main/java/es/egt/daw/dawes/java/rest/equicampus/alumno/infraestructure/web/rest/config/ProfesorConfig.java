package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.CreateProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.DeleteProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.EditProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.FindProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.CreateProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.DeleteProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.EditProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.FindProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.repository.profesor.ProfesorEntityJpaRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.repository.profesor.ProfesorJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProfesorConfig {

  private final ProfesorEntityJpaRepository profesorRepository;

   @Bean
   public  ProfesorRepository profesorRepository(){
        return new ProfesorJpaRepositoryImpl(profesorRepository);
    }

@Bean
public CreateProfesorUseCase createProfesorUseCase() {
    return new CreateProfesorUseCase(profesorRepository());
}

@Bean
public CreateProfesorService createProfesorService() {
    return new CreateProfesorService(createProfesorUseCase());
}

@Bean
public FindProfesorUseCase findProfesorUseCase() {
    return new FindProfesorUseCase(profesorRepository());
}

@Bean
public FindProfesorService findProfesorService() {
    return new FindProfesorService(findProfesorUseCase());
}

@Bean
public DeleteProfesorUseCase deleteProfesorUseCase() {
    return new DeleteProfesorUseCase(profesorRepository());
}

@Bean
public DeleteProfesorService deleteProfesorService() {
    return new DeleteProfesorService(deleteProfesorUseCase());
}

@Bean
public EditProfesorUseCase editProfesorUseCase() {
    return new EditProfesorUseCase(profesorRepository());
}

@Bean
public EditProfesorService editProfesorService() {
    return new EditProfesorService(editProfesorUseCase());
}

}
