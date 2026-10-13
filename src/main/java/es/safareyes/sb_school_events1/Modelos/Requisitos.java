package es.safareyes.sb_school_events1.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "requisitos")
public class Requisitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    public Requisitos() {
    }

    public Requisitos(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Requisitos{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}