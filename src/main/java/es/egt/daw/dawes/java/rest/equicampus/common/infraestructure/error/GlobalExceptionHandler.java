package es.egt.daw.dawes.java.rest.equicampus.common.infraestructure.error;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {
     
    private final MessageSource messageSource;
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomResponse> nullPointerHandler(NullPointerException nfe) {

       
        Object [] datos = new Object[]{
                nfe 
                };
        String msg = messageSource.getMessage(
                        "common.error.null_pointer", 
                        datos, 
                        Locale.getDefault()); 


        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, msg);
        return new ResponseEntity<>(cr, cr.getStatus());
    }
}
