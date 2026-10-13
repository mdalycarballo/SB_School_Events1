package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Categoria;

import java.util.List;

public interface ICategoria {
    List<Categoria> findAllByOrderByNombreAsc();
}
