
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
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.repository.mock.ProfesorFactory;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor.ProfesorRequest;
import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.web.rest.dto.profesor.ProfesorResponse;



@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProfesorControllerIT {

    public static String ENDPOINT = "/profesor";

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private JacksonTester<ProfesorRequest> jsonProfesorRequest;

    @Autowired
    private JacksonTester<ProfesorResponse> jsonProfesorResponse;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    @Order(1)
    public void When_Get_AllProfesor_Expect_Lista() throws Exception {

        int numProfesores = ProfesorFactory.getDemoData().values().size();

        MockHttpServletResponse response = mockMvc.perform(
                get(ENDPOINT).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        List<ProfesorResponse> res = mapper.readValue(
                response.getContentAsString(),
                mapper.getTypeFactory().constructCollectionType(List.class, ProfesorResponse.class)
        );

        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertTrue(numProfesores == res.size())
        );
    }

    @Test
    @Order(10)
    public void When_Post_CreateProfesor() throws Exception {

        Profesor nuevo = ProfesorFactory.create();
        ProfesorRequest req = new ProfesorRequest(nuevo);

        MockHttpServletResponse response = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProfesorRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        ProfesorResponse res = mapper.readValue(response.getContentAsString(), ProfesorResponse.class);

        assertAll(
                () -> assertEquals(HttpStatus.CREATED.value(), response.getStatus()),
                () -> assertEquals(res.nombre(), nuevo.getNombre()),
                () -> assertEquals(res.apellido(), nuevo.getApellidos()),
                () -> assertTrue(res.id() > 0)
        );
    }

    @Test
    @Order(11)
    public void Error_ValidationError_When_CreateProfesor_EmptyNombre() throws Exception {

        Profesor nuevo = ProfesorFactory.create();
        nuevo.setNombre(null);

        ProfesorRequest req = new ProfesorRequest(nuevo);

        MockHttpServletResponse response = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProfesorRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    @Order(20)
    public void When_Put_EditProfesor() throws Exception {

        Profesor nuevo = ProfesorFactory.create();
        nuevo.setProfesorId(new ProfesorId(1));

        ProfesorRequest req = new ProfesorRequest(nuevo);

        MockHttpServletResponse response = mockMvc.perform(
                put(ENDPOINT + "/" + nuevo.getProfesorId().getValue())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProfesorRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        ProfesorResponse res = mapper.readValue(response.getContentAsString(), ProfesorResponse.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertEquals(res.nombre(), nuevo.getNombre()),
                () -> assertEquals(res.apellido(), nuevo.getApellidos()),
                () -> assertEquals(res.id(), nuevo.getProfesorId().getValue())
        );
    }

    @Test
    @Order(30)
    public void When_Delete_DeleteProfesor() throws Exception {

        Profesor nuevo = ProfesorFactory.create();
        nuevo.setProfesorId(new ProfesorId(1));

        ProfesorRequest req = new ProfesorRequest(nuevo);

        MockHttpServletResponse response = mockMvc.perform(
                delete(ENDPOINT + "/" + nuevo.getProfesorId().getValue())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProfesorRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }
}
