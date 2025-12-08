package es.egt.daw.dawes.java.rest.equicampus.application.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.FindAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.alumno.FindAlumnoUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.AlumnoFactory;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@ExtendWith(MockitoExtension.class)
public class FindAlumnoServiceTest {

    @Mock
    private FindAlumnoUseCase findAlumnoUseCase;

    @InjectMocks
    private FindAlumnoService findAlumnoService;

    @Test

   void findAll() {
        // Lo que vamos a simular: El caso de uso
        when(findAlumnoUseCase.findAll())
                .thenReturn(List.copyOf(AlumnoFactory.getDemoData().values()));
                var list = findAlumnoService.findAll();

                assertAll(

                    ()-> assertNotNull(list),
                    ()-> assertEquals(AlumnoFactory.getDemoData().values().size(), list.size())
                );

                verify(findAlumnoUseCase, times(1)).findAll();
   }
}
