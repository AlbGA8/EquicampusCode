package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.profesor;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;

public record ProfesorRequest (String nombre, String apellido){

     public ProfesorRequest(Profesor p) {
        this(p.getNombre(), p.getApellidos());
       
    }


}
