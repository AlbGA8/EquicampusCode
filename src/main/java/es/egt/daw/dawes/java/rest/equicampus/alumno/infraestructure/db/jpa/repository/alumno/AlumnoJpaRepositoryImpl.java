package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.repository.alumno;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.AlumnoRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.alumno.AlumnoEntity;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper.AlumnoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class AlumnoJpaRepositoryImpl implements AlumnoRepository {
    
   private final AlumnoEntityJpaRepository repository;

@Override
public Alumno save(Alumno t) {
    AlumnoEntity alumnoEntity = AlumnoMapper.toEntity(t);
    return AlumnoMapper.toDomain(repository.save(alumnoEntity));
}

@Override
public List<Alumno> getAll() {
    return AlumnoMapper.toDomain(repository.findAll());
}

@Override
public Optional<Alumno> getById(AlumnoId id) {
        Optional<Alumno> alumno = null;
        Optional<AlumnoEntity> al = repository.findById(id.getValue());

        if (al.isEmpty()) {
            alumno = Optional.empty();
        } else {
            alumno = Optional.of(AlumnoMapper.toDomain(al.get()));
        }

        return alumno;
    }
@Override
public void deteteById(AlumnoId id) {
    repository.deleteById(id.getValue());
}

@Override
public Optional<Alumno> getByName(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getByName'");
}


    

}
