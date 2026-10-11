package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Inscripcion;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IInscripcion extends JpaRepository<Inscripcion, Integer> {

    List<Inscripcion> findByUsuarioIdAndTipo(Integer usuarioId, String tipo);
    List<Inscripcion> findByUsuarioId(Integer usuarioId);



    Page<Inscripcion> findByEventoIdOrderByFechaInscripcionAsc(Integer eventoId, Pageable pageable);

    //Esto no se porque esta mal, probar interfaz y si no funciona cambiar los Integer eventoId por Evento a secas!!a

}
