package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.profesor;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoProfesorValidator.class)
@Documented
public @interface NombradoProfesor {

    // Definimos el mensaje por defecto
    String message() default "{es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.profesor.NombradoProfesor}";

    // Permite agrupar validaciones. Es útil cuando quieres validar solo un
    // subconjunto de reglas
    // (por ejemplo, validar un producto para "Creación" vs. para "Actualización").
    // El valor por defecto es para todos los casos.
    Class<?>[] groups() default {};

    // Una propiedad avanzada que permite definir metadatos o códigos de error
    // específicos al resultado de la validación.
    Class<? extends Payload>[] payload() default {};

}