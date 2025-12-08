package es.egt.daw.dawes.java.rest.equicampus.infraestructure.db.repository.alumno;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.AlumnoFactory;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.AlumnoRepositoryMockImpl;

public class AlumnoRepositoryMockImplTest {

     AlumnoRepository repository = new AlumnoRepositoryMockImpl();
    @BeforeEach
    void setUp() {
       
        repository = new AlumnoRepositoryMockImpl();
        

    }

    @Test
    void save(){
        var alumnos = AlumnoFactory.create();
      
        Alumno a = repository.save(alumnos);

        assertAll(
                () -> assertNotNull(a), 
                () -> assertNotNull(a.getAlumnoId()), 
                () -> assertNotNull(repository.getById(a.getAlumnoId())) 
        );
        
    }

    @Test
    void getAll() {
        var alumnos = repository.getAll();

        assertAll(
                () -> assertNotNull(alumnos),
                () -> assertEquals(AlumnoFactory.getDemoData().size(), alumnos.size())
        );
    }


}
