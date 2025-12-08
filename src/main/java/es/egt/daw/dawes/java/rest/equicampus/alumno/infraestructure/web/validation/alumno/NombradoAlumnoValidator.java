package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.alumno;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoAlumnoValidator implements ConstraintValidator<NombradoAlumno, String> {

    public final static String STR_BLANCO = " ";
    public final static String STR_SALTO = "\n";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if (value == null || value.length() == 0 || value.contains(STR_SALTO))
            return false;

        return true;
    }

}