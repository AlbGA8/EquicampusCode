package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.egt.daw.dawes.java.rest.equicampus.common.domain.error.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlumnoNotFoundException extends EntityNotFoundException {
      
    public static final String ENTIDAD = "Alumno";

    public AlumnoNotFoundException() {
        super(ENTIDAD);
    }
    public AlumnoNotFoundException(int id) {
        super(ENTIDAD, id);
    }   

    public AlumnoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
