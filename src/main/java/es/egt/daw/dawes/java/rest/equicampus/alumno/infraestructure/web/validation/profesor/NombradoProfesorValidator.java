package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.profesor;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

public class NombradoProfesorValidator implements ConstraintValidator<NombradoProfesor, String> {

    public final static String STR_BLANCO = " ";
    public final static String STR_SALTO = "\n";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        /* Vamos a validar el campo producto aplicando las siguientes normas:
        *  No es nulo, vacío, ni tiene blancos
        */
        if(value == null || value.length()==0 ||  value.contains(STR_SALTO))
            return false;
        
        return true;
    }

}
