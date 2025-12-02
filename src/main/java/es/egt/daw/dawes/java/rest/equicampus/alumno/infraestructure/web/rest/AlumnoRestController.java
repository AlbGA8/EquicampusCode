package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.CreateAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.AlumnoRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.dto.AlumnoResponse;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.mapper.AlumnoMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alumnos")

public class AlumnoRestController {

    private final CreateAlumnoService createAlumnoService;

    @PostMapping

    public ResponseEntity<AlumnoResponse> createAlumno(@RequestBody AlumnoRequest alumnoRequest){
        CreateAlumnoCommand comando = AlumnoMapper.toCommand(alumnoRequest);
        Alumno alumno = createAlumnoService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(alumno));
    }

}
