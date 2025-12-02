package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.mapper;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.AlumnoRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.AlumnoResponse;

public class AlumnoMapper {

    public static CreateAlumnoCommand toCommand(AlumnoRequest alumnoRequest){
        return new CreateAlumnoCommand(alumnoRequest.nombre(),alumnoRequest.apellido());
    }

    public static AlumnoResponse toResponse( Alumno alumno){
        return new AlumnoResponse(alumno.getAlumnoId().getValue(),
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getCreatedAt());
    }

}
