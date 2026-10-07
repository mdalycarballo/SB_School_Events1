package es.safareyes.sb_school_events1.Repositorios;


import es.safareyes.sb_school_events1.Modelos.evento;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEvento extends JpaRepository<evento, Integer> {

    @EntityGraph(attributePaths = {"categoria"})
    List<evento> findByCategoria_id(IEvento categoria_id);

    @EntityGraph(attributePaths = {"categoria"})
    List<evento> findByCreador_id(IEvento creator_id);

    @EntityGraph(attributePaths = {"categoria"})
    List<evento> findByLugar_id(IEvento lugar_id);

    List<evento> findByFecha_inicio(IEvento fecha_inicio);

    List<evento> findByFecha_fin(IEvento fecha_fin);

    List<evento> findByTitulo(IEvento titulo);

    List<evento> findByEstado(IEvento estado);

}