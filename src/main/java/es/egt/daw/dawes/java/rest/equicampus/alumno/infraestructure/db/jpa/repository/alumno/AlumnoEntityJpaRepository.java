package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.repository.alumno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.alumno.AlumnoEntity;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Repository
public interface AlumnoEntityJpaRepository extends JpaRepository<AlumnoEntity, Integer> {

    public AlumnoEntity findByNombre(String nombre);
}
