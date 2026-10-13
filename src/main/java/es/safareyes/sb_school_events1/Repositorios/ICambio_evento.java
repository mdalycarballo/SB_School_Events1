package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Cambio_evento;

import java.util.List;

public interface ICambio_evento {
    List<Cambio_evento> findByEventoIdOrderByFechaDesc(Integer eventoId);
}
