package es.safareyes.sb_school_events1.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "foto_publicacion")
public class Foto_publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    private Publicacion publicacion;

    @Column(name = "url_foto")
    private String urlFoto;

    @Column(name = "tamano")
    private Integer tamano;

    public Foto_publicacion() {
    }

    public Foto_publicacion(Integer id, Publicacion publicacion, String urlFoto, Integer tamano) {
        this.id = id;
        this.publicacion = publicacion;
        this.urlFoto = urlFoto;
        this.tamano = tamano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Foto_publicacion{" +
                "id=" + id +
                ", urlFoto='" + urlFoto + '\'' +
                ", tamano=" + tamano +
                '}';
    }
}