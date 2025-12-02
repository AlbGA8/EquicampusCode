package es.egt.daw.dawes.java.rest.equicampus.alumnos.infraestructure.db.jpa.repository.profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.egt.daw.dawes.java.rest.equicampus.alumnos.infraestructure.db.jpa.entity.profesor.ProfesorEntity;

@Repository
public interface ProfesorEntityJpaRepository extends JpaRepository <ProfesorEntity,Integer> {

}
