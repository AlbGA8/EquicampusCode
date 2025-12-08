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

import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.FindProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.usecase.profesor.FindProfesorUseCase;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.ProfesorFactory;

@ExtendWith(MockitoExtension.class)
public class FindProfesorServiceTest {

    @Mock
    private FindProfesorUseCase findProfesorUseCase;

    @InjectMocks
    private FindProfesorService findProfesorService;

    @Test

   void findAll() {
        // Lo que vamos a simular: El caso de uso
        when(findProfesorUseCase.findAll())
                .thenReturn(List.copyOf(ProfesorFactory.getDemoData().values()));
                var list = findProfesorService.findAll();

                assertAll(

                    ()-> assertNotNull(list),
                    ()-> assertEquals(ProfesorFactory.getDemoData().values().size(), list.size())
                );

                verify(findProfesorUseCase, times(1)).findAll();
   }
}
