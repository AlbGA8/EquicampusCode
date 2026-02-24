package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.profesor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.alumno.AlumnoEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Entity
@Table(name = "PROFESOR")
@AllArgsConstructor
@Builder
@Data
public class ProfesorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Integer profesorId;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String apellido;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlumnoEntity> alumnos = new ArrayList<AlumnoEntity>();

    public ProfesorEntity() {
    }
    

 
    public ProfesorEntity(Integer profesorId, String nombre, String apellido) {
        this.profesorId = profesorId;
        this.nombre = nombre;
        this.apellido = apellido;
        
    }



    public void addAlumno(AlumnoEntity alumno) {
        this.alumnos.add(alumno);
        alumno.setProfesor(this); // Sincroniza el lado Alumno
    }

    public void removeAlumno(AlumnoEntity alumno) {
        this.alumnos.remove(alumno);
        alumno.setProfesor(null); // Desvincula el Alumno
    }

}