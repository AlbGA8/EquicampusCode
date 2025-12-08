package es.egt.daw.dawes.java.rest.equicampus.infraestructure.db.jpa.repository.alumno;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.repository.alumno.AlumnoEntityJpaRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.AlumnoFactory;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper.AlumnoMapper;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@DataJpaTest(showSql = true)
public class AlumnoEntityJpaRepositoryTest {
    
    @Autowired

    private AlumnoEntityJpaRepository repository;




    @Test
    @Order(1)
    void findAll() {

        var alumno = repository.findAll();


        assertAll(
                () -> assertNotNull(alumno),
                () -> assertTrue(!alumno.isEmpty())
        );
    }

    @Test
    @Order(2)
    void findById(){
        
        update(); // Actualizo y recupero el dato controlado
        var a = AlumnoFactory.create(); //Producto cambiado antes, vamos a ve rsi está bien

        var alumno = repository.findById(a.getAlumnoId().getValue()).get();

        assertAll(
            () -> assertNotNull(alumno),
            () -> assertEquals(alumno.getAlumnoId(), a.getAlumnoId().getValue()),
            () -> assertEquals(alumno.getNombre(), a.getNombre()),
            ()-> assertEquals(alumno.getApellidos(),a.getApellidos())
        );
    }


    @Test
    @Order(3)
    void findByName(){
      
        update(); // Actualizo y recupero el dato controlado
        var a = AlumnoFactory.create(); //Producto cambiado antes, vamos a ve rsi está bien

        var alumno = repository.findByNombre(a.getNombre());

        assertAll(
            () -> assertNotNull(alumno),
            () -> assertEquals(alumno.getAlumnoId(), a.getAlumnoId().getValue()),
            () -> assertEquals(alumno.getNombre(), a.getNombre()),
            ()-> assertEquals(alumno.getApellidos(),a.getApellidos())
            
        );
    }    

    @Test
    @Order(5)
    void create(){
        var nuevo = AlumnoMapper.toEntity(AlumnoFactory.create());
        nuevo.setAlumnoId(null);
        var alumno = repository.save(nuevo);

                assertAll(
                () -> assertNotNull(alumno),
                () -> assertTrue(alumno.getAlumnoId()!=null)
        );
    }

    @Test
    @Order(10)
    void update(){
        var nuevo = AlumnoMapper.toEntity(AlumnoFactory.create());
        var alumno = repository.save(nuevo);

                assertAll(
                () -> assertNotNull(alumno),
                () -> assertTrue(alumno.getAlumnoId()!=null)
        );
    }


    @Test
    @Order(15)
    void delete(){
        var alumno = repository.findById(1); 
        repository.delete(alumno.get());

        var alumnoEliminado = repository.findById(1).isEmpty();
        assertAll(
            () -> assertTrue(alumnoEliminado)
        );
    }


}
