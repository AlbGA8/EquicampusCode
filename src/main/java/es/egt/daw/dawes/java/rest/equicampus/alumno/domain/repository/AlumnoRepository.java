package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository;

import java.util.Optional;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.common.domain.repository.CRUDRepository;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

public interface AlumnoRepository extends CRUDRepository<Alumno, AlumnoId> {

    public Optional<Alumno> getByName(String name);
    

}
