package es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.enums;

/**
 * Representa los posibles atributos que podemos usar
 * en los modelos de la vista
 */
public enum ModelAttribute {
    ALUMN("alumnos"),
    SINGLE_ALUMN("alumno"),
    ERROR_MESSAGE("errorMsg"),
    TEACHER("profesores"),
    SINGLE_TEACHER("profesor"),
    PUPILAJES("pupilajes"),
    CLASSES("clases"),
    PAYMENTS("pagos"),
    FRAGMENTS("content"),
    SUCCESS_MESSAGE("successMsg");


    private final String name;

    ModelAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
