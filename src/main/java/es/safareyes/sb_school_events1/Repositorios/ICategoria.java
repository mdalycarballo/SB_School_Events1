package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoria extends JpaRepository<Categoria, Integer> {
    List<Categoria> findAllByOrderByNombreAsc();
}
