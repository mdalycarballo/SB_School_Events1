package es.safareyes.sb_school_events1.Repositorios;


import es.safareyes.sb_school_events1.Modelos.Evento_curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEvento_curso extends JpaRepository<Evento_curso, Integer> {
    List<Evento_curso> findByEvento_Id(Integer eventoId);
    boolean existsByEvento_IdAndCurso_Id(Integer eventoId, Integer cursoId);
}
