package es.egt.daw.dawes.java.rest.equicampus.alumno.domain.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import es.egt.daw.dawes.java.rest.equicampus.common.domain.error.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfesorNotFoundException extends EntityNotFoundException {

      public static final String ENTIDAD = "Profesor";

    public ProfesorNotFoundException() {
        super(ENTIDAD);
    }
    public ProfesorNotFoundException(int id) {
        super(ENTIDAD, id);
    }   

    public ProfesorNotFoundException(String mensaje) {
        super(mensaje);
    }

}
