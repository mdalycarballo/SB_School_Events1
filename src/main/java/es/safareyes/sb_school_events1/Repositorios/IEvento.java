package es.safareyes.sb_school_events1.Repositorios;


import es.safareyes.sb_school_events1.Modelos.Evento;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEvento extends JpaRepository<Evento, Integer> {

    @EntityGraph(attributePaths = {"categoria"})
    List<Evento> findByCategoria_id(IEvento categoria_id);

    @EntityGraph(attributePaths = {"categoria"})
    List<Evento> findByCreador_id(IEvento creator_id);

    @EntityGraph(attributePaths = {"categoria"})
    List<Evento> findByLugar_id(IEvento lugar_id);

    List<Evento> findByFecha_inicio(IEvento fecha_inicio);

    List<Evento> findByFecha_fin(IEvento fecha_fin);

    List<Evento> findByTitulo(IEvento titulo);

    List<Evento> findByEstado(IEvento estado);

}