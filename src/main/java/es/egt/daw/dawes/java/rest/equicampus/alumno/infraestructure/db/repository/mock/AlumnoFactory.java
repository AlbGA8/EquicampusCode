package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;


/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */


public class AlumnoFactory {

        public static final Map<AlumnoId, Alumno> getDemoData(){
        Map<AlumnoId, Alumno> datos = new LinkedHashMap<>();
            datos.put(new AlumnoId(1), new Alumno(new AlumnoId(1), "Juan", "Pérez García", LocalDateTime.now(), new ProfesorId(1), "juan.perez@example.com"));
            datos.put(new AlumnoId(2), new Alumno(new AlumnoId(2), "María", "López Sánchez", LocalDateTime.now(), new ProfesorId(2), "maria.lopez@example.com"));
            datos.put(new AlumnoId(3), new Alumno(new AlumnoId(3), "Carlos", "Martínez Rodríguez", LocalDateTime.now(), new ProfesorId(1), "carlos.martinez@example.com"));
            

        return datos;
    }
  public static final Alumno create() { return new Alumno(new AlumnoId(1), "Paco", "Pérez", LocalDateTime.now(), new ProfesorId(1), "paco.perez@example.com"); }


}
