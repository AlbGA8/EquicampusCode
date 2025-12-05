package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.alumno;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoAlumnoValidator.class)
@Documented
public @interface NombradoAlumno {
//Definimos el mensaje por defecto
    String message() default "{es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.alumno.NombradoAlumno.message}";
//Permite agrupar validaciones. Es útil cuando quieres validar solo un subconjunto de reglas 
//(por ejemplo, validar un alumno para "Creación" vs. para "Actualización
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}