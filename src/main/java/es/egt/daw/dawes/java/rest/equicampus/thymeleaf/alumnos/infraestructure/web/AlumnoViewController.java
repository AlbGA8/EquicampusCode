package es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import java.io.OutputStream;
import java.util.List;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.thymeleaf.context.Context;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.CreateAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.FindAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.FindProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.constants.WebRoutes;
import es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.enums.ModelAttribute;
import es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.enums.ThymView;
import jakarta.servlet.http.HttpServletResponse;

@Controller

public class AlumnoViewController {

    private FindAlumnoService findAlumnoServiceTf;
    private CreateAlumnoService createAlumnoServiceTf;
    private FindProfesorService findProfesorService;
    private TemplateEngine templateEngine; // Motor de Thymeleaf

    public AlumnoViewController(FindAlumnoService findAlumnoServiceTf, CreateAlumnoService createAlumnoServiceTf,
            FindProfesorService findProfesorService,
            TemplateEngine templateEngine) {
        this.findAlumnoServiceTf = findAlumnoServiceTf;
        this.createAlumnoServiceTf = createAlumnoServiceTf;
        this.templateEngine = templateEngine;
        this.findProfesorService = findProfesorService;
    }

    // Listado de Alumnos http://localhost:8082/web/alumnos/pdf
    @GetMapping(WebRoutes.ALUMNOS_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        // Obtengo los datos
        List<Alumno> alumnos = findAlumnoServiceTf.findAll();
        // Preparar el contexto de Thymeleaf
        Context context = new Context();
        context.setVariable("alumnos", alumnos);

        // Ya tengo los datos en el contexto de Thymeleaf, ahora le doy la plantilla
        // para que me devuelva
        // la plantilla con los datos rellenos (el mismo html que estamos devolviendo al
        // usuario pero ahora lo meto en un String).
        String htmlContent = templateEngine.process(ThymView.ALUMN_LIST_PDF.getPath(), context);

        // Preparo la respuesta diciendole que voy a devolver un pdf
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=alumnos.pdf");

        // Código OpenHTML to PDF - CAMBIOS
        // ******************************
        OutputStream outputStream = response.getOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(htmlContent, null); // El 'null' es la base URL
        builder.toStream(outputStream);
        builder.run();

    }


    @GetMapping(WebRoutes.ALUMNOS_BASE) // O la ruta que uses para el home
    public String index(Model model) {
        // 1. Cargar lista de alumnos para la tabla
        model.addAttribute(ModelAttribute.ALUMN_LIST.getName(), findAlumnoServiceTf.findAll());

        // 2. Cargar lista de profesores para el select del formulario
        model.addAttribute("profesores", findProfesorService.findAll());

        // 3. Objeto vacío para el formulario "Nuevo Alumno"
        model.addAttribute("alumno", new Alumno());

        return ThymView.ALUMN_LIST.getPath(); // Devuelve la vista del listado de alumnos
    }

    // Este método crea el alumno y devuelve la vista del mensaje de creado
    @PostMapping(WebRoutes.ALUMNOS_NUEVO)
    public String crearAlumno(@RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam Integer profesor,
            @RequestParam String email,
            Model model) {
        ProfesorId profId = new ProfesorId(profesor);
        createAlumnoServiceTf.createAlumno(new CreateAlumnoCommand(nombre, apellido, profId, email));
        return "alumnos-creado";
    }

}
