package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Repository

public class ProfesorRepositoryMockImpl implements ProfesorRepository {

        private final Map<ProfesorId, Profesor> profesor = ProfesorFactory.getDemoData();

    @Override
    public Profesor save(Profesor p) {
        if (p.getProfesorId() == null)
            p.setProfesorId(new ProfesorId(obtenerSiguienteId()));
        profesor.put(p.getProfesorId(), p);
        return p;
    }

    private int obtenerSiguienteId() {
        ProfesorId ultimo = null;
        if (!profesor.isEmpty()) {

            Collection<Profesor> lista = profesor.values();

            for (Profesor a : lista) {
                ultimo = a.getProfesorId();
            }

        }
        return ultimo.getValue() + 1;
    }

    @Override
    public List<Profesor> getAll() {
       return new ArrayList<>(profesor.values());
    }

    @Override
    public Optional<Profesor> getById(ProfesorId id) {
        return Optional.ofNullable(profesor.get(id));
    }

    @Override
    public void deteteById(ProfesorId id) {
        profesor.remove(id);
    }

    @Override
    public Optional<Profesor> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
