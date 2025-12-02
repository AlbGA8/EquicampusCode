package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository;
import java.util.Optional;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.common.repository.CRUDRepository;

public interface ProfesorRepository extends CRUDRepository <Profesor, ProfesorId> {

    public Optional<Profesor> getByName(String name);
    Optional<Profesor> getById(ProfesorId profesorId);
}
