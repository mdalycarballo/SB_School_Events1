package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Evento_requisito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEvento_requisito extends JpaRepository<Evento_requisito, Integer> {
    List<Evento_requisito> findByEvento_Id(Integer eventoId);
}
