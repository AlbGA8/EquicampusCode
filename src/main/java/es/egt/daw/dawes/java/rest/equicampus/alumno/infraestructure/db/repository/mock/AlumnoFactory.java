package es.egt.daw.dawes.java.rest.equicampus.alumnos.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.egt.daw.dawes.java.rest.equicampus.alumnos.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumnos.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumnos.domain.model.identifiers.ProfesorId;

public class AlumnoFactory {

        public static final Map<AlumnoId, Alumno> getDemoData(){
        Map<AlumnoId, Alumno> datos = new LinkedHashMap<>();
            datos.put(new AlumnoId(1), new Alumno(new AlumnoId(1), "Juan", "Pérez García", LocalDateTime.now(), new ProfesorId(1)));
            datos.put(new AlumnoId(2), new Alumno(new AlumnoId(2), "María", "López Sánchez", LocalDateTime.now(), new ProfesorId(2)));
            datos.put(new AlumnoId(3), new Alumno(new AlumnoId(3), "Carlos", "Martínez Rodríguez", LocalDateTime.now(), new ProfesorId(1)));

        return datos;
    }

}
