package es.egt.daw.dawes.java.rest.equicampus.thymeleaf.alumnos.infraestructure.web.Fragments;

public enum FragmentoContenido {
    
    ALUMNOS("views/alumnos"),
    PROFESORES("views/profesores"),
    PAGOS("views/pagos"),
    PUPILAJES("views/pupilajes"),
    PISTAS("views/pistas"),
    CLASES("views/clases"),
    DASHBOARD("views/dashboard");



    private final String path;

    FragmentoContenido(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    } 
}