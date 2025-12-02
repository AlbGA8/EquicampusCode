package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.EditAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.alumno.AlumnoRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.alumno.AlumnoResponse;

public class AlumnoMapper {

    public static CreateAlumnoCommand toCommand(AlumnoRequest alumnoRequest){
        return new CreateAlumnoCommand(alumnoRequest.nombre(),alumnoRequest.apellido(), new ProfesorId(alumnoRequest.profesor()));
    }

    public static EditAlumnoCommand toCommand(int id, AlumnoRequest alumnoRequest ){
        return new EditAlumnoCommand(new AlumnoId(id), alumnoRequest.nombre(), alumnoRequest.apellido());
    }

    public static AlumnoResponse toResponse( Alumno alumno){
        return new AlumnoResponse(alumno.getAlumnoId().getValue(),
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getCreatedAt());
    }
    

}
