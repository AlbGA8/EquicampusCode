package es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.enums;

/**
 * Contiene el listado de plantillas Thymeleaf
 */
public enum ThymView {
    MAIN_DASHBOARD("index"),
    ALUMN_LIST_PDF("/pdf/alumnos-lista"),
    ALUMN_DETAIL("alumnos-detalle"),
    ERROR_GENERIC("error/error-general");

    private final String path;

    ThymView(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
