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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.CreateProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.EditProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.CreateProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.DeleteProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.EditProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.FindProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor.ProfesorRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor.ProfesorResponse;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.mapper.ProfesorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorRestController {

    private final FindProfesorService findProfesorService;
    private final CreateProfesorService createProfesorService;
    private final EditProfesorService editProfesorService;
    private final DeleteProfesorService deleteProfesorService;

    @PostMapping
    public ResponseEntity<ProfesorResponse> createAlumno(@Valid @RequestBody ProfesorRequest profesorRequest) {
        CreateProfesorCommand comando = ProfesorMapper.toCommand(profesorRequest);
        Profesor profesor = createProfesorService.createProfesor(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfesorMapper.toResponse(profesor));
    }
    @Value("${api.version}")
    private String apiVersion;


    @GetMapping
      public List<ProfesorResponse> allCategorias(){
        
        if("1.0".equals(apiVersion)){
            return findProfesorService.findAll()
                    .stream() 
                    .map(ProfesorMapper::toResponse) 
                    .toList(); 
        }else{
           
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Versión del API incorrecta");
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesor(@PathVariable int id){
        deleteProfesorService.delete(new ProfesorId(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ProfesorResponse editProfesor(@PathVariable int id, @RequestBody ProfesorRequest profesorRequest){
       EditProfesorCommand comando = ProfesorMapper.toCommand(id, profesorRequest);
       Profesor profesor = editProfesorService.update(comando);
        return ProfesorMapper.toResponse(profesor);
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
