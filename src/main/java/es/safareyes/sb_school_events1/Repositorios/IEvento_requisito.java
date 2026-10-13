package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Inscripcion;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IEvento_requisito {
    List<Inscripcion> findByUsuarioIdAndTipo(Integer usuarioId, String tipo);
    List<Inscripcion> findByUsuarioId(Integer usuarioId);
    Page<Inscripcion> findByEventoIdOrderByFechaInscripcionAsc(Integer eventoId, Pageable pageable);
}
