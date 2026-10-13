package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Evento_curso;

import java.util.List;

public interface IEvento_curso {
    List<Evento_curso> findByEventoId(Long eventoId);
    boolean existsByEventoIdAndCursoId(Long eventoId, Long cursoId);
}
