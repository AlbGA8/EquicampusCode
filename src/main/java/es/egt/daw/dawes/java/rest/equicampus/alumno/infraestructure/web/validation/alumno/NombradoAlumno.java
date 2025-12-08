package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.alumno;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoAlumnoValidator.class)
@Documented
public @interface NombradoAlumno {

    // Definimos el mensaje por defecto
    String message() default "{es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.alumno.NombradoAlumno}";

    // Permite agrupar validaciones. Es útil cuando quieres validar solo un
    // subconjunto de reglas
    // (por ejemplo, validar un producto para "Creación" vs. para "Actualización").
    // El valor por defecto es para todos los casos.
    Class<?>[] groups() default {};

    // Una propiedad avanzada que permite definir metadatos o códigos de error
    // específicos al resultado de la validación.
    Class<? extends Payload>[] payload() default {};

}