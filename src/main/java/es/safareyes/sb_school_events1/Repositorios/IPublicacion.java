package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Publicacion;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface IPublicacion {
    @EntityGraph(attributePaths = {"fotos", "usuario"})
    List<Publicacion> findByEventoId(Integer eventoId);
}
