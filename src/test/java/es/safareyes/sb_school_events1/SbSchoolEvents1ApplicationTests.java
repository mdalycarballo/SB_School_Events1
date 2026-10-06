package es.safareyes.sb_school_events1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbSchoolEvents1ApplicationTests {

    @Test
    void contextLoads() {
        /* select * from especie e
                where
                        ('neon' is null or nombre_comun like '%neon')
                and
                        (null is null or temperature_max > 20)
        //esto esta filtrando todo que sea mas de 20,

                and
                        (:temp is null or temperatura_max > :temp);
        //la tarea final tiene que tener consultas simples y consultas que tengan filtros y todo...
    */
    }
}
