package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Foto_publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFoto_publicacion extends JpaRepository<Foto_publicacion, Integer> {
    List<Foto_publicacion> findByPublicacion_Id(Integer publicacionId);
}
