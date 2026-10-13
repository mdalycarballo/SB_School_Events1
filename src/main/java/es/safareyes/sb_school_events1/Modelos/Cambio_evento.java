package es.safareyes.sb_school_events1.Modelos;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cambio_evento")
public class Cambio_evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Column(name = "cambios")
    private String cambios;

    @Column(name = "fecha")
    private Timestamp fecha;

    public Cambio_evento() {
    }

    public Cambio_evento(Integer id, Evento evento, String cambios, Timestamp fecha) {
        this.id = id;
        this.evento = evento;
        this.cambios = cambios;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getCambios() {
        return cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cambio_evento{" +
                "id=" + id +
                ", cambios='" + cambios + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}