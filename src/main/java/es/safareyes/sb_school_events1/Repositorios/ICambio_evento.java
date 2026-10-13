package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Cambio_evento;
import es.safareyes.sb_school_events1.Modelos.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICambio_evento extends JpaRepository<Cambio_evento, Integer> {
    List<Cambio_evento> findByEvento_IdOrderByFechaDesc(Integer eventoId);
}
