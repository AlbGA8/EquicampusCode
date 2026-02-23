package es.egt.daw.dawes.java.rest.equicampus.infraestructure.web.res;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.AlumnoFactory;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.alumno.AlumnoRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.alumno.AlumnoResponse;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@ActiveProfiles("test")
// Indicamos que es un test de Spring
@SpringBootTest
// Configuramos el cliente MVC
@AutoConfigureMockMvc
// Configuramos los testers de JSON (recuerda que usabamos json en postman)
@AutoConfigureJsonTesters
// Limpiamos el contexto antes de cada test (queremos que todas las pruebas se
// ejecuten sin datos de otras)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AlumnoControllerIT {
    // Constante para las rutas
    public static String ENDPOINT = "/alumnos";

    // Json
    private ObjectMapper mapper = new ObjectMapper();

    // Cargamos el cliente MVC
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private JacksonTester<AlumnoRequest> jsonAlumnoRequest;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    @Order(1)
    public void When_Get_AllAlumno_Expect_Lista() throws Exception {



        MockHttpServletResponse response = mockMvc.perform(

                get(ENDPOINT).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        List<AlumnoResponse> res = mapper.readValue(response.getContentAsString(),
                mapper.getTypeFactory().constructCollectionType(List.class, AlumnoResponse.class));

        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.OK.value()), // Ha ido bien
                () -> assertTrue(res.size() >0 ));
    }

    @Test
    @Order(10)
    public void When_Post_CreateAlumno() throws Exception {
        Alumno nuevo = AlumnoFactory.create();

        AlumnoRequest req = new AlumnoRequest(nuevo);

        MockHttpServletResponse response = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)

                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Gestiono la respuesta
        AlumnoResponse res = mapper.readValue(response.getContentAsString(), AlumnoResponse.class);

        // Evaluo la salida
        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.CREATED.value()), // Ha ido bien
                () -> assertEquals(res.nombre(), nuevo.getNombre()),
                () -> assertEquals(res.apellido(), nuevo.getApellido()),
                () -> assertEquals(res.profesor(), nuevo.getProfesor().getValue()),
                () -> assertTrue(res.id() > 0));
    }

    /**
     * Si se crea un producto sin nombre debe dar MethodArgumentNotValidException
     * la respuesta debería ser HttpStatus.BAD_REQUEST
     */
    @Test
    @Order(11)
    public void Error_ValidationError_When_CreateAlumno_EmptyNombre() throws Exception {
        Alumno nuevo = AlumnoFactory.create();
        nuevo.setNombre(null);

        AlumnoRequest req = new AlumnoRequest(nuevo);

        // Realizo la petición POST
        MockHttpServletResponse response = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        // Le paso el body
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Comprobamos
        assertAll(
                () -> assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus()));
    }

    @Test
    @Order(20)
    public void When_Put_EditAlumno() throws Exception {
        Alumno nuevo = AlumnoFactory.create();
        nuevo.setAlumnoId(new AlumnoId(1));

        AlumnoRequest req = new AlumnoRequest(nuevo);

        // Realizo la petición POST
        MockHttpServletResponse response = mockMvc.perform(
                // productos/{id} -> productos/1
                put(ENDPOINT + "/" + nuevo.getAlumnoId().getValue())
                        .contentType(MediaType.APPLICATION_JSON)
                        // Le paso el body
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Gestiono la respuesta
        AlumnoResponse res = mapper.readValue(response.getContentAsString(), AlumnoResponse.class);

        // Evaluo la salida
        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.OK.value()), // Ha ido bien
                () -> assertEquals(res.nombre(), nuevo.getNombre()),
                () -> assertEquals(res.apellido(), nuevo.getApellido()),
                () -> assertEquals(res.profesor(), nuevo.getProfesor().getValue()),
                () -> assertEquals(res.id(), nuevo.getAlumnoId().getValue()));
    }

    @Test
    @Order(30)
    public void When_Delete_DeleteAlumno() throws Exception {
        Alumno nuevo = AlumnoFactory.create();
        nuevo.setAlumnoId(new AlumnoId(1));

        AlumnoRequest req = new AlumnoRequest(nuevo);

        // Realizo la petición POST
        MockHttpServletResponse response = mockMvc.perform(
                // productos/{id} -> productos/1
                delete(ENDPOINT + "/" + nuevo.getAlumnoId().getValue())
                        .contentType(MediaType.APPLICATION_JSON)
                        // Le paso el body
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.NO_CONTENT.value()) // Ha ido bien
        );
    }

}
