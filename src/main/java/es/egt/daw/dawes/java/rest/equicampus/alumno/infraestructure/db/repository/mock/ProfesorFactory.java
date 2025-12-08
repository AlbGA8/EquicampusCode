package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;

public class ProfesorFactory {


        public static final Map<ProfesorId, Profesor> getDemoData(){
        Map<ProfesorId, Profesor> datos = new LinkedHashMap<>();
            datos.put(new ProfesorId(1), new Profesor("Paco", "Gomez Carrillo", new ProfesorId(1), LocalDateTime.now()));
            datos.put(new ProfesorId(1), new Profesor("Luis", "Peralta Garcia", new ProfesorId(1), LocalDateTime.now()));
            datos.put(new ProfesorId(1), new Profesor("Estoncio", "nuñez balboa", new ProfesorId(1), LocalDateTime.now()));
            datos.put(new ProfesorId(1), new Profesor("Javier", "Jimenez Carrasco", new ProfesorId(1), LocalDateTime.now()));
        return datos;
    }
  public static final Profesor create() { return  new Profesor("Javier", "Jimenez Carrasco", new ProfesorId(1), LocalDateTime.now()); }


}

