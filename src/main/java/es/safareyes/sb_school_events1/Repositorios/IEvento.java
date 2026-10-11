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

    /* Si el otro no funciona probar este!!
    @EntityGraph(attributePaths = {"lugar", "categoria", "cursos"})
    Optional<Evento> findWithDetailsById(Long id);

    List<Evento> findByInicioBetweenAndEstadoIn(LocalDateTime inicio, LocalDateTime fin, List<String> estados);

    @Query("SELECT e FROM Evento e WHERE e.lugar.id = :lugarId AND e.estado <> 'CANCELADO' " +
           "AND (:inicio < e.fin AND :fin > e.inicio) " +
           "AND (:eventoId IS NULL OR e.id <> :eventoId)")
    List<Evento> findSolapamientos(@Param("lugarId") Long lugarId,
                                  @Param("inicio") LocalDateTime inicio,
                                  @Param("fin") LocalDateTime fin,
                                  @Param("eventoId") Long eventoId);

    @Query(value = "SELECT c.nombre AS categoria, cu.nombre AS curso, COUNT(DISTINCT i.usuario_id) AS total_asistentes " +
                   "FROM evento e " +
                   "JOIN categoria c ON e.categoria_id = c.id " +
                   "JOIN inscripcion i ON i.evento_id = e.id " +
                   "JOIN usuario u ON i.usuario_id = u.id " +
                   "LEFT JOIN curso cu ON u.curso_id = cu.id " +
                   "WHERE e.estado = 'FINALIZADO' AND i.asistio = true " +
                   "AND e.inicio >= :desde AND e.fin <= :hasta " +
                   "GROUP BY c.nombre, cu.nombre",
           nativeQuery = true)
    List<Object[]> obtenerInformeParticipacion(@Param("desde") LocalDateTime desde, @Param("hasta") LocalDateTime hasta);
     */
}