package es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.alumno;



import java.time.LocalDateTime;

import es.egt.daw.dawes.java.rest.equicampus.alumno.infraestructure.db.jpa.entity.profesor.ProfesorEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "ALUMNO")
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "alumno_id")
    private Integer alumnoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id", nullable = false)
    private ProfesorEntity profesor;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;


    
    // --- Constructores ---
    public AlumnoEntity() {
    }

    // Constructor con campos (simplificado)
    public AlumnoEntity(Integer id, String nombre,String apellidos, LocalDateTime createdAt, ProfesorEntity profesor) {
        this.alumnoId = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.createdAt = createdAt;
        this.profesor = profesor;
    }

  


}




