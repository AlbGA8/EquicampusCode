package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.CreateProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.EditProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.profesor.ProfesorEntity;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.profesor.ProfesorRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.profesor.ProfesorResponse;


public class ProfesorMapper {

    public static CreateProfesorCommand toCommand(ProfesorRequest profesorRequest) {
        return new CreateProfesorCommand(profesorRequest.nombre(), profesorRequest.apellido());
    }

    public static EditProfesorCommand toCommand(int id, ProfesorRequest profesorRequest) {
        // pasamos del int a CategoriaId
        return new EditProfesorCommand(new ProfesorId(id), profesorRequest.nombre(), profesorRequest.apellido());
    }

    public static ProfesorResponse toResponse(Profesor profesor) {
        return new ProfesorResponse(profesor.getProfesorId().getValue(), profesor.getNombre(), profesor.getApellidos(),
                profesor.getCreatedAt());

    }

    public static ProfesorEntity toEntity(Profesor p) {

        ProfesorId id = p.getProfesorId();
        return ProfesorEntity.builder().profesorId(id != null ? id.getValue() : null)
                .nombre(p.getNombre())
                .build();

    }

    public static Profesor toDomain(ProfesorEntity p) {
        return Profesor.builder().profesorId(new ProfesorId(p.getProfesorId()))
                .nombre(p.getNombre())
                .build();

    }

    public static List<Profesor> toDomain(List<ProfesorEntity> lista) {
        List<Profesor> lp = new ArrayList<>();
        for (ProfesorEntity pe : lista) {
            lp.add(toDomain(pe));
        }
        return lp;
    }

}
