package es.egt.daw.dawes.java.rest.equicampus.alumnos.infraestructure.db.jpa.entity.alumno;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ALUMNO")
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private Long alumnoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = true)
    //private ProfesorEntity profesor;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}




