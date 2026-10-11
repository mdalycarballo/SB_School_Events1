package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICurso extends JpaRepository<Curso, Integer> {
    Optional<Curso> findByNombreIgnoreCase(String nombre);
}
