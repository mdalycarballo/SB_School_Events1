package es.safareyes.sb_school_events1.Repositorios;

import es.safareyes.sb_school_events1.Modelos.Lugar;

import java.util.List;

public interface ILugar {
    List<Lugar> findAllByOrderByNombreAsc();
}
