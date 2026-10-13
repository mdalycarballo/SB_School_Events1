package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INotificacion extends JpaRepository<Notificacion, Integer> {
    List<Notificacion> findByUsuario_IdOrderByFechaDesc(Integer usuarioId);
    List<Notificacion> findByUsuario_IdAndLeidaFalse(Integer usuarioId);
}
