package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.EditAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.alumno.AlumnoEntity;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.profesor.ProfesorEntity;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.alumno.AlumnoRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.alumno.AlumnoResponse;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

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
                alumno.getCreatedAt(),
                alumno.getProfesor().getValue());

    
    }


    public static AlumnoEntity toEntity(Alumno a) {

    // Defino el profesor
    ProfesorEntity prof = new ProfesorEntity();
    prof.setProfesorId(a.getProfesor().getValue());

    AlumnoId id = a.getAlumnoId();
    return AlumnoEntity.builder()
            .alumnoId(id != null ? id.getValue() : null)
            .nombre(a.getNombre())
            .apellidos(a.getApellidos())
            .createdAt(a.getCreatedAt())
            .profesor(prof) // Relación 1:N
            .build();
}

public static Alumno toDomain(AlumnoEntity a) {
    return Alumno.builder()
            .alumnoId(new AlumnoId(a.getAlumnoId()))
            .nombre(a.getNombre())
            .apellidos(a.getApellidos())
            .createdAt(a.getCreatedAt())
            .profesor(new ProfesorId(a.getProfesor().getProfesorId()))
            .build();
}

public static List<Alumno> toDomain(List<AlumnoEntity> lista) {
    List<Alumno> la = new ArrayList<>();
    for (AlumnoEntity ae : lista) {
        la.add(toDomain(ae));
    }
    return la;
}

    

}
