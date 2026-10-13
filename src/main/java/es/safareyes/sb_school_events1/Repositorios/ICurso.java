package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Curso;

import java.util.Optional;

public interface ICurso {
    Optional<Curso> findByNombreIgnoreCase(String nombre);
}
