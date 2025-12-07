package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.alumno;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.validation.alumno.NombradoAlumno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlumnoRequest(
        @NotBlank(message = "{alumno.valid.nombre.no_vacio}") @NombradoAlumno(message = "{alumno.valid.nombre.nombrado_validation}") String nombre,
        @NotBlank(message = "{alumno.valid.apellido.no_vacio}") @NombradoAlumno(message = "{alumno.valid.apellido.nombrado_validation}") String apellido,
        @NotNull(message = "{alumno.valid.profesor.no_vacio}") Integer profesor) {

    // Constructor desde la entidad Alumno
    public AlumnoRequest(Alumno alumno) {
        this(
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getProfesor().getValue());
    }
}
