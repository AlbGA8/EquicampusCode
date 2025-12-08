package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;



@Repository

public class AlumnoRepositoryMockImpl implements AlumnoRepository {

    private final Map<AlumnoId, Alumno> alumnos = AlumnoFactory.getDemoData();

    @Override
    public Alumno save(Alumno t) {
        if (t.getAlumnoId() == null)
            t.setAlumnoId(new AlumnoId(obtenerSiguienteId()));
        alumnos.put(t.getAlumnoId(), t);
        return t;
    }

    private int obtenerSiguienteId() {
        AlumnoId ultimo = null;
        if (!alumnos.isEmpty()) {

            Collection<Alumno> lista = alumnos.values();

            for (Alumno a : lista) {
                ultimo = a.getAlumnoId();
            }

        }
        return ultimo.getValue() + 1;
    }

    @Override
    public List<Alumno> getAll() {
       return new ArrayList<>(alumnos.values());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
         return Optional.ofNullable(alumnos.get(id));
    }

    @Override
    public void deteteById(AlumnoId id) {
        alumnos.remove(id);
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
}
