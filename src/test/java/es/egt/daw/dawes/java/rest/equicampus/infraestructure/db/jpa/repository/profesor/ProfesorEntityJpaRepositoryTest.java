package es.egt.daw.dawes.java.rest.equicampus.infraestructure.db.jpa.repository.profesor;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.repository.profesor.ProfesorEntityJpaRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.ProfesorFactory;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper.ProfesorMapper;

@DataJpaTest(showSql = true)
public class ProfesorEntityJpaRepositoryTest {

    @Autowired
    private ProfesorEntityJpaRepository repository;
    @Order(1)
    void findAll(){

        var profesores = repository.findAll();


        assertAll(
                () -> assertNotNull(profesores),
                () -> assertTrue(!profesores.isEmpty())
        );
    }

    @Test
    @Order(2)
    void findById(){
        update(); 
        var al = ProfesorFactory.create(); 

        var p = repository.findById(al.getProfesorId().getValue()).get();

        assertAll(
            () -> assertNotNull(p),
            () -> assertEquals(p.getProfesorId(), al.getProfesorId().getValue()),
            () -> assertEquals(p.getNombre(), al.getNombre())
        );
    }


    

    @Test
    @Order(5)
    void create(){
        var nuevo = ProfesorMapper.toEntity(ProfesorFactory.create());
        nuevo.setProfesorId(null);
        var p = repository.save(nuevo);

        assertAll(
            () -> assertNotNull(p),
            () -> assertTrue(p.getProfesorId()!=null)
            );
    }

    @Test
    @Order(10)
    void update(){
        var nuevo = ProfesorMapper.toEntity(ProfesorFactory.create());
        var alumno = repository.save(nuevo);

                assertAll(
                () -> assertNotNull(alumno),
                () -> assertTrue(alumno.getProfesorId()!=null)
        );
    }


    @Test
    @Order(15)
    void delete(){
        var p = repository.findById(1); 
        repository.delete(p.get());

        var pEliminado = repository.findById(1).isEmpty();
        assertAll(
            () -> assertTrue(pEliminado)
        );
    }


    

}
