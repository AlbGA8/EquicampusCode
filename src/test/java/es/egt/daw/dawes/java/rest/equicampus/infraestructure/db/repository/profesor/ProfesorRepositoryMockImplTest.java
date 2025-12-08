package es.egt.daw.dawes.java.rest.equicampus.infraestructure.db.repository.profesor;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.ProfesorFactory;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.ProfesorRepositoryMockImpl;

public class ProfesorRepositoryMockImplTest {
        ProfesorRepository repository = new ProfesorRepositoryMockImpl();
    @BeforeEach
    void setUp() {
      
        repository = new ProfesorRepositoryMockImpl();
        

    }

    @Test
    void save(){
        var profesor = ProfesorFactory.create();
      
        Profesor p = repository.save(profesor);

        assertAll(
                () -> assertNotNull(p), 
                () -> assertNotNull(p.getProfesorId()), 
                () -> assertNotNull(repository.getById(p.getProfesorId())) 
        );
        
    }

    @Test
    void getAll() {
        var profesor = repository.getAll();

        assertAll(
                () -> assertNotNull(profesor),
                () -> assertEquals(ProfesorFactory.getDemoData().size(), profesor.size())
        );
    }


}
