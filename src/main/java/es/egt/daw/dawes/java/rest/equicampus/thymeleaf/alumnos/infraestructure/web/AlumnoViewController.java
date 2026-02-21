package es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import java.io.OutputStream;
import java.util.List;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.thymeleaf.context.Context;
import es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.enums.ModelAttribute;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.CreateAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.alumno.EditAlumnoCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.command.profesor.CreateProfesorCommand;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.CreateAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.DeleteAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.EditAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.alumno.FindAlumnoService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.CreateProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.application.services.profesor.FindProfesorService;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Alumno;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.entity.Profesor;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.AlumnoId;
import es.egt.daw.dawes.java.rest.equicampus.alumno.domain.model.identifiers.ProfesorId;
import es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.fragments.FragmentoContenido;
import es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.constants.WebRoutes;
import es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.enums.ThymView;
import jakarta.servlet.http.HttpServletResponse;

@Controller

public class AlumnoViewController {

    String REDIRECT = "redirect:%s?exito=true";

    private final DeleteAlumnoService deleteAlumnoService;
    private final EditAlumnoService editAlumnoService;
    private FindAlumnoService findAlumnoServiceTf;
    private CreateAlumnoService createAlumnoServiceTf;
    private CreateProfesorService createProfesorService;
    private FindProfesorService findProfesorService;
    private TemplateEngine templateEngine; // Motor de Thymeleaf

    public AlumnoViewController(FindAlumnoService findAlumnoServiceTf, CreateAlumnoService createAlumnoServiceTf,
            FindProfesorService findProfesorService, CreateProfesorService createProfesorService,
            TemplateEngine templateEngine, DeleteAlumnoService deleteAlumnoService,
            EditAlumnoService editAlumnoService) {
        this.findAlumnoServiceTf = findAlumnoServiceTf;
        this.createAlumnoServiceTf = createAlumnoServiceTf;
        this.templateEngine = templateEngine;
        this.findProfesorService = findProfesorService;
        this.createProfesorService = createProfesorService;
        this.deleteAlumnoService = deleteAlumnoService;
        this.editAlumnoService = editAlumnoService;
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

    // ------------------
    // --CARGAR VISTAS---
    // ------------------
    // 1. RUTA DASHBOARD
    @GetMapping(WebRoutes.DASHBOARD)
    public String dashboard(Model model) {
        model.addAttribute(ModelAttribute.ALUMN.getName(), findAlumnoServiceTf.findAll());
        // Solo pasamos la ruta del archivo HTML.
        // Thymeleaf lo unirá con ":: contenidoVista" gracias a tu index.html
        model.addAttribute(ModelAttribute.CONTENIDO.getName(), FragmentoContenido.DASHBOARD.getPath());
        return ThymView.MAIN_DASHBOARD.getPath(); // Siempre devolvemos el layout base
    }

    // 2. RUTA ALUMNOS
    @GetMapping(WebRoutes.ALUMNOS_BASE)
    public String alumnos(Model model) {
        // Cargamos SOLO los datos de alumnos
        model.addAttribute(ModelAttribute.ALUMN.getName(), findAlumnoServiceTf.findAll());
        model.addAttribute(ModelAttribute.TEACHER.getName(), findProfesorService.findAll());

        // Le indicamos el archivo de la vista
        model.addAttribute(ModelAttribute.CONTENIDO.getName(), FragmentoContenido.ALUMNOS.getPath());
        return ThymView.MAIN_DASHBOARD.getPath();
    }

    // 3. RUTA PROFESORES
    @GetMapping(WebRoutes.PROFESORES_BASE)
    public String profesores(Model model) {
        // Cargamos SOLO los datos de profesores
        model.addAttribute(ModelAttribute.TEACHER.getName(), findProfesorService.findAll());

        // Le indicamos el archivo de la vista
        model.addAttribute(ModelAttribute.CONTENIDO.getName(), FragmentoContenido.PROFESORES.getPath());
        return ThymView.MAIN_DASHBOARD.getPath();
    }

    // 4. RUTA PAGOS
    @GetMapping(WebRoutes.PAGOS)
    public String pagos(Model model) {
        model.addAttribute(ModelAttribute.CONTENIDO.getName(), FragmentoContenido.PAGOS.getPath());
        return ThymView.MAIN_DASHBOARD.getPath();
    }

    // 5. RUTA PUPILAJES
    @GetMapping(WebRoutes.PUPILAJES)
    public String pupilajes(Model model) {
        model.addAttribute(ModelAttribute.CONTENIDO.getName(), FragmentoContenido.PUPILAJES.getPath());
        return ThymView.MAIN_DASHBOARD.getPath();
    }

    // 6. RUTA PISTAS
    @GetMapping(WebRoutes.PISTAS)
    public String pistas(Model model) {
        model.addAttribute(ModelAttribute.CONTENIDO.getName(), FragmentoContenido.PISTAS.getPath());
        return ThymView.MAIN_DASHBOARD.getPath();
    }

    // 7. RUTA CLASES
    @GetMapping(WebRoutes.CLASES)
    public String clases(Model model) {
        model.addAttribute(ModelAttribute.CONTENIDO.getName(), FragmentoContenido.CLASES.getPath());
        return ThymView.MAIN_DASHBOARD.getPath();
    }

    // MODAL EDITAR ALUMNO
    @GetMapping(WebRoutes.ALUMNOS_EDITAR_MODAL)
    public String prepararEdicion(@PathVariable Integer id, Model model) {

        // 1. Buscamos el alumno
        Alumno alumno = findAlumnoServiceTf.findById(new AlumnoId(id))
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + id));

        // 2. Ahora pasamos el objeto Alumno real, no el Optional
        model.addAttribute(ModelAttribute.SINGLE_ALUMN.getName(), alumno);
        model.addAttribute(ModelAttribute.TEACHER.getName(), findProfesorService.findAll());

        return "fragments/modals :: modal-editar-alumno";
    }

    // EDITAR ALUMNO
    @PostMapping(WebRoutes.ALUMNOS_EDITAR)
    public String editarAlumno(
            @PathVariable Integer id,
            @RequestParam Integer profesor,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String email) {
        ProfesorId profId = new ProfesorId(profesor);
        // Ejecutamos la actualización real
        editAlumnoService.update(new EditAlumnoCommand(new AlumnoId(id), nombre, apellido,
                profId,
                email));

        return String.format(REDIRECT, ThymView.ALUMNOS.getPath());
    }

    // BORRAR ALUMNO
    @DeleteMapping(WebRoutes.ALUMNOS_ELIMINAR )
    @ResponseBody
    public void eliminarAlumno(@PathVariable Integer id, HttpServletResponse response) {
        deleteAlumnoService.delete(new AlumnoId(id));
        // Esta cabecera le dice a HTMX que refresque la página completa
        response.addHeader("HX-Refresh", "true");
    }

    // MODAL BORRAR ALUMNO
    @GetMapping(WebRoutes.ALUMNOS_ELIMINAR_MODAL)
    public String modalConfirmarEliminacion(@PathVariable Integer id, Model model) {
        model.addAttribute(ModelAttribute.ID.getName(), id);
        // Puedes buscar el nombre del alumno si quieres mostrar "¿Borrar a Juan Pérez?"
        return "fragments/modals :: modal-eliminar-alumno";
    }

    // -----------------//
    // --CREAR ALUMNO---//
    // -----------------//
    // Este método crea el alumno y devuelve la vista del mensaje de creado
    @PostMapping(WebRoutes.ALUMNOS_NUEVO)
    public String crearAlumno(@RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam Integer profesor,
            @RequestParam String email,
            Model model) {
        ProfesorId profId = new ProfesorId(profesor);
        createAlumnoServiceTf.createAlumno(new CreateAlumnoCommand(nombre, apellido, profId, email));
        // return "redirect:" + WebRoutes.ALUMNOS_BASE + "?exito=true#alumnos";
        return String.format(REDIRECT, ThymView.ALUMNOS.getPath());
    }

    // MODAL DE ALUMNOS
    @GetMapping(WebRoutes.NUEVO_ALUMNO)
    public String obtenerModalNuevo(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_ALUMN.getName(), new Alumno());
        model.addAttribute(ModelAttribute.TEACHER.getName(), findProfesorService.findAll());
        // Apuntamos al fragmento específico
        return "fragments/modals :: modal-nuevo-alumno";
    }

    // -------------------//
    // --CREAR PROFESOR---//
    // -------------------//
    @PostMapping(WebRoutes.PROFESOR_NUEVO) // Asegúrate de definir esta ruta en tus WebRoutes
    public String crearProfesor(@RequestParam String nombre,
            @RequestParam String apellido,
            Model model) {

        // Llamar a tu servicio de creación de profesores
        // createProfesorService.createProfesor(command);
        createProfesorService.createProfesor(new CreateProfesorCommand(nombre, apellido));
        // Redirigir al dashboard con la pestaña de profesores activa y mensaje de éxito
        // Usamos el hash #profesores para que el JS active esa pestaña al recargar
        return String.format(REDIRECT, ThymView.PROFESORES.getPath());
    }

    // MODAL DE PROFESORES
    @GetMapping(WebRoutes.NUEVO_PROFESOR)
    public String obtenerModalNuevoProfesor(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_TEACHER.getName(), new Profesor());
        return "fragments/modals :: modal-nuevo-profesor";
    }

}