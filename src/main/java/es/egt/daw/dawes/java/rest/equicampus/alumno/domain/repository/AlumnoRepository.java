package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository;

import java.util.Optional;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.common.domain.repository.CRUDRepository;

public interface AlumnoRepository extends CRUDRepository<Alumno, AlumnoId> {

    public Optional<Alumno> getByName(String name);
    

}
