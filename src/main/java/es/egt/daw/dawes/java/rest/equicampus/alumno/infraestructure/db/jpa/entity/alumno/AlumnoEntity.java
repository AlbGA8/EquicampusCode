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

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

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

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id", nullable = false)
    private ProfesorEntity profesor;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

     @Column(name = "email", nullable = false)
    private String email;


    
    // --- Constructores ---
    public AlumnoEntity() {
    }

    // Constructor con campos (simplificado)
    public AlumnoEntity(Integer id, String nombre,String apellido, LocalDateTime createdAt, ProfesorEntity profesor, String email) {
        this.alumnoId = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.createdAt = createdAt;
        this.profesor = profesor;
        this.email = email;
    }

  


}




