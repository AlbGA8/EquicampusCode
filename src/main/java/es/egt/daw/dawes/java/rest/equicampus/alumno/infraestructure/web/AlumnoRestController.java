package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.EditAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.CreateAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.DeleteAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.EditAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.FindAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.alumno.AlumnoRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.alumno.AlumnoResponse;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper.AlumnoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/alumnos")

public class AlumnoRestController {

    private final CreateAlumnoService createAlumnoService;
    private final FindAlumnoService findAlumnoService;
    private final EditAlumnoService editAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;


    @PostMapping
    public ResponseEntity<AlumnoResponse> createAlumno(@Valid @RequestBody AlumnoRequest alumnoRequest){
        CreateAlumnoCommand comando = AlumnoMapper.toCommand(alumnoRequest);
        Alumno alumno = createAlumnoService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(alumno));
    }

    @Value("${api.version}")
    private String apiVersion;

    @GetMapping
    public List<AlumnoResponse> allAlumnos(){
           if("1.0".equals(apiVersion)){
            return findAlumnoService.findAll()
                    .stream() // Convertir la lista de Alumno a un Stream
                    .map(AlumnoMapper::toResponse) // Mapear cada Alumno a AlumnoResponse
                    .toList(); // Convertir la lista de Alumno a lista de AlumnoResponse
        }else{
            // Manejar la versión incorrecta del API
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Versión del API incorrecta");
        }
        
    }

    @PutMapping("/{id}")
    public AlumnoResponse editAlumno(@PathVariable int id, @RequestBody AlumnoRequest alumnoRequest){
       EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
       Alumno alumno = editAlumnoService.update(comando);
        return AlumnoMapper.toResponse(alumno);
    }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteAlumno(@PathVariable int id){
    
    deleteAlumnoService.delete(new AlumnoId(id));
    return ResponseEntity.noContent().build();
   }

   @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
