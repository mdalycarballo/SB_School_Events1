package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Publicacion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPublicacion extends JpaRepository<Publicacion, Integer> {

    @EntityGraph(attributePaths = {"fotos", "usuario"})
    List<Publicacion> findByEvento_Id(Integer eventoId);
}
