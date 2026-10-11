package es.safareyes.sb_school_events1.Repositorios;


import es.safareyes.sb_school_events1.Modelos.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILugar extends JpaRepository<Lugar, Integer> {
    List<Lugar> findAllByOrderByNombreAsc();
}
