package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.repository.profesor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.repository.ProfesorRepository;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.profesor.ProfesorEntity;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper.ProfesorMapper;
import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class ProfesorJpaRepositoryImpl implements ProfesorRepository {

    private final ProfesorEntityJpaRepository repository;

    @Override
    public Profesor save(Profesor t) {

        ProfesorEntity prof = ProfesorMapper.toEntity(t);

        return ProfesorMapper.toDomain(repository.save(prof));
    }

    @Override
    public List<Profesor> getAll() {
       return ProfesorMapper.toDomain(repository.findAll());
    }

    @Override
    public void deteteById(ProfesorId id) {
       repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Profesor> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

    @Override
    public Optional<Profesor> getById(ProfesorId profesorId) {
      Optional<Profesor> Profesor = null;
      Optional<ProfesorEntity> pe = repository.findById(profesorId.getValue());
       if (pe.isEmpty()) {
            Profesor = Optional.empty();
        } else {
            Profesor = Optional.of(ProfesorMapper.toDomain(pe.get()));
        }

        return Profesor;
    }

}
