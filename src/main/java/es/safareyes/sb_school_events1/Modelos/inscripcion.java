package es.safareyes.sb_school_events1.Modelos;

import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@Entity
@Table(name = "cat_continente")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "usuario_id")
    private usuario usuario_id;

    @Column(name = "evento_id")
    private evento evento_id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "asistido")
    private Boolean asistido;

    @Column(name = "fecha")
    private Timestamp fecha;
}
