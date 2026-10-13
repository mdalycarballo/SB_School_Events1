package es.safareyes.sb_school_events1;

import es.safareyes.sb_school_events1.Modelos.*;
import es.safareyes.sb_school_events1.Repositorios.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
@Transactional
public class Test_SE {

    @Autowired
    private ICambio_evento cambioEventoRepository;

    @Autowired
    private ICategoria categoriaRepository;

    @Autowired
    private ICurso cursoRepository;

    @Autowired
    private IEvento eventoRepository;

    @Autowired
    private IEvento_curso eventoCursoRepository;

    @Autowired
    private IEvento_requisito eventoRequisitoRepository;

    @Autowired
    private IFoto_publicacion fotoPublicacionRepository;

    @Autowired
    private IInscripcion inscripcionRepository;

    @Autowired
    private ILugar lugarRepository;

    @Autowired
    private INotificacion notificacionRepository;

    @Autowired
    private IPublicacion publicacionRepository;

    @Autowired
    private IRequisitos requisitosRepository;

    @Autowired
    private IUsuario usuarioRepository;

    // --- MÉTODOS AUXILIARES CON SETTERS Y GENERACIÓN DE NOMBRES/EMAILS ÚNICOS ---

    private Curso crearCurso() {
        Curso c = new Curso();
        c.setNombre("1º DAM " + System.currentTimeMillis());
        c.setNivel("FP Superior");
        return cursoRepository.save(c);
    }

    private Usuario crearUsuario(Curso curso) {
        Usuario u = new Usuario();
        u.setNombre("Juan Pérez");
        u.setEmail("juan_" + System.currentTimeMillis() + "@safareyes.es");
        u.setPassword("secret");
        u.setTipo("Estudiante"); // O el valor permitido por tu restricción CHECK (ej. "ESTUDIANTE", "ADMIN", etc.)
        u.setEstado("ACTIVO");
        u.setFechaInscripcion(new Timestamp(System.currentTimeMillis()));
        u.setCurso(curso);
        return usuarioRepository.save(u);
    }

    private Categoria crearCategoria() {
        Categoria cat = new Categoria();
        cat.setNombre("Tecnología " + System.currentTimeMillis());
        cat.setIcono("code.png");
        cat.setColor("#3357FF");
        return categoriaRepository.save(cat);
    }

    private Lugar crearLugar() {
        Lugar l = new Lugar();
        l.setNombre("Salón de Actos " + System.currentTimeMillis());
        l.setAforoMax(150);
        return lugarRepository.save(l);
    }

    private Evento crearEvento(Usuario creador, Categoria categoria, Lugar lugar) {
        Evento e = new Evento();
        e.setTitulo("Feria de Ciencias " + System.currentTimeMillis());
        e.setDescripcion("Evento de muestra");
        e.setEstado("PUBLICADO");
        e.setFechaInicio(new Timestamp(System.currentTimeMillis()));
        e.setFechaFin(new Timestamp(System.currentTimeMillis() + 3600000));
        e.setAforoMaximo(100);
        e.setCreador(creador);
        e.setCategoria(categoria);
        e.setLugar(lugar);
        return eventoRepository.save(e);
    }

    private Publicacion crearPublicacion(Evento evento, Usuario usuario) {
        Publicacion p = new Publicacion();
        p.setEvento(evento);
        p.setUsuario(usuario);
        p.setTexto("Inauguración exitosa");
        p.setResultados("Gran afluencia");
        p.setFecha(new Timestamp(System.currentTimeMillis()));
        return publicacionRepository.save(p);
    }

    private Requisitos crearRequisito() {
        Requisitos requisitos = new Requisitos();
        requisitos.setDescripcion("Llevar portátil " + System.currentTimeMillis());
        return requisitosRepository.save(requisitos);
    }

    // --- TEST PRINCIPAL: MUESTRA TODAS LAS ENTIDADES EN CONSOLA ---

    @Test
    @DisplayName("00. Impresión completa de datos de la base de datos")
    void printAllData() {
        Curso c = crearCurso();
        Usuario u = crearUsuario(c);
        Categoria cat = crearCategoria();
        Lugar l = crearLugar();
        Evento e = crearEvento(u, cat, l);
        Requisitos r = crearRequisito();
        Publicacion p = crearPublicacion(e, u);

        Cambio_evento cambio = new Cambio_evento();
        cambio.setEvento(e);
        cambio.setCambios("Aforo ampliado a 200");
        cambio.setFecha(new Timestamp(System.currentTimeMillis()));
        cambio = cambioEventoRepository.save(cambio);

        Evento_curso ec = new Evento_curso();
        ec.setEvento(e);
        ec.setCurso(c);
        ec = eventoCursoRepository.save(ec);

        Evento_requisito er = new Evento_requisito();
        er.setEvento(e);
        er.setRequisito(r);
        er = eventoRequisitoRepository.save(er);

        Inscripcion ins = new Inscripcion();
        ins.setUsuario(u);
        ins.setEvento(e);
        ins.setTipo("PRESENCIAL");
        ins.setEstado("CONFIRMADA");
        ins.setAsistio(false);
        ins.setFecha(new Timestamp(System.currentTimeMillis()));
        ins = inscripcionRepository.save(ins);

        Foto_publicacion foto = new Foto_publicacion();
        foto.setPublicacion(p);
        foto.setUrlFoto("http://imagen.jpg");
        foto.setTamano(2048);
        foto = fotoPublicacionRepository.save(foto);

        Notificacion noti = new Notificacion();
        noti.setUsuario(u);
        noti.setEvento(e);
        noti.setTipo("RECORDATORIO");
        noti.setMensaje("El evento empieza pronto");
        noti.setLeida(false);
        noti.setFecha(new Timestamp(System.currentTimeMillis()));
        noti = notificacionRepository.save(noti);

        System.out.println("\n=======================================================");
        System.out.println("          REGISTROS GUARDADOS EN LA BD ");
        System.out.println("=======================================================");
        System.out.println("--> CURSO:             " + c);
        System.out.println("--> USUARIO:           " + u);
        System.out.println("--> CATEGORIA:         " + cat);
        System.out.println("--> LUGAR:             " + l);
        System.out.println("--> EVENTO:            " + e);
        System.out.println("--> CAMBIO EVENTO:     " + cambio);
        System.out.println("--> EVENTO_CURSO:      " + ec);
        System.out.println("--> REQUISITOS:        " + r);
        System.out.println("--> EVENTO_REQUISITO:  " + er);
        System.out.println("--> INSCRIPCION:       " + ins);
        System.out.println("--> PUBLICACION:       " + p);
        System.out.println("--> FOTO_PUBLICACION:  " + foto);
        System.out.println("--> NOTIFICACION:      " + noti);
        System.out.println("=======================================================\n");
    }

    // --- TESTS INDIVIDUALES ---

    @Test
    @DisplayName("01. Test y Print Curso")
    void testCurso() {
        Curso curso = crearCurso();
        System.out.println("[PRINT] Curso guardado: " + cursoRepository.findById(curso.getId()).orElse(null));
    }

    @Test
    @DisplayName("02. Test y Print Usuario")
    void testUsuario() {
        Usuario usuario = crearUsuario(crearCurso());
        System.out.println("[PRINT] Usuario guardado: " + usuarioRepository.findById(usuario.getId()).orElse(null));
    }

    @Test
    @DisplayName("03. Test y Print Categoria")
    void testCategoria() {
        crearCategoria();
        List<Categoria> lista = categoriaRepository.findAllByOrderByNombreAsc();
        System.out.println("[PRINT] Listado Categorías: " + lista);
    }

    @Test
    @DisplayName("04. Test y Print Lugar")
    void testLugar() {
        Lugar lugar = crearLugar();
        System.out.println("[PRINT] Lugar guardado: " + lugarRepository.findById(lugar.getId()).orElse(null));
    }

    @Test
    @DisplayName("05. Test y Print Evento")
    void testEvento() {
        Evento e = crearEvento(crearUsuario(crearCurso()), crearCategoria(), crearLugar());
        System.out.println("[PRINT] Evento guardado: " + eventoRepository.findById(e.getId()).orElse(null));
    }

    @Test
    @DisplayName("06. Test y Print Cambio_evento")
    void testCambioEvento() {
        Evento e = crearEvento(crearUsuario(crearCurso()), crearCategoria(), crearLugar());
        Cambio_evento cambio = new Cambio_evento();
        cambio.setEvento(e);
        cambio.setCambios("Aforo ampliado a 200");
        cambio.setFecha(new Timestamp(System.currentTimeMillis()));
        cambio = cambioEventoRepository.save(cambio);
        System.out.println("[PRINT] Cambio Evento guardado: " + cambio);
    }

    @Test
    @DisplayName("07. Test y Print Evento_curso")
    void testEventoCurso() {
        Curso c = crearCurso();
        Evento e = crearEvento(crearUsuario(c), crearCategoria(), crearLugar());
        Evento_curso ec = new Evento_curso();
        ec.setEvento(e);
        ec.setCurso(c);
        ec = eventoCursoRepository.save(ec);
        System.out.println("[PRINT] Evento_Curso guardado: " + ec);
    }

    @Test
    @DisplayName("08. Test y Print Evento_requisito")
    void testEventoRequisito() {
        Evento e = crearEvento(crearUsuario(crearCurso()), crearCategoria(), crearLugar());
        Requisitos r = crearRequisito();
        Evento_requisito er = new Evento_requisito();
        er.setEvento(e);
        er.setRequisito(r);
        er = eventoRequisitoRepository.save(er);
        System.out.println("[PRINT] Evento_Requisito guardado: " + er);
    }

    @Test
    @DisplayName("09. Test y Print Inscripcion")
    void testInscripcion() {
        Usuario u = crearUsuario(crearCurso());
        Evento e = crearEvento(u, crearCategoria(), crearLugar());
        Inscripcion ins = new Inscripcion();
        ins.setUsuario(u);
        ins.setEvento(e);
        ins.setTipo("PRESENCIAL");
        ins.setEstado("CONFIRMADA");
        ins.setAsistio(false);
        ins.setFecha(new Timestamp(System.currentTimeMillis()));
        ins = inscripcionRepository.save(ins);
        System.out.println("[PRINT] Inscripción guardada: " + ins);
    }

    @Test
    @DisplayName("10. Test y Print Publicacion")
    void testPublicacion() {
        Usuario u = crearUsuario(crearCurso());
        Evento e = crearEvento(u, crearCategoria(), crearLugar());
        Publicacion p = crearPublicacion(e, u);
        System.out.println("[PRINT] Publicación guardada: " + p);
    }

    @Test
    @DisplayName("11. Test y Print Foto_publicacion")
    void testFotoPublicacion() {
        Usuario u = crearUsuario(crearCurso());
        Evento e = crearEvento(u, crearCategoria(), crearLugar());
        Publicacion p = crearPublicacion(e, u);
        Foto_publicacion foto = new Foto_publicacion();
        foto.setPublicacion(p);
        foto.setUrlFoto("http://imagen.jpg");
        foto.setTamano(2048);
        foto = fotoPublicacionRepository.save(foto);
        System.out.println("[PRINT] Foto_Publicación guardada: " + foto);
    }

    @Test
    @DisplayName("12. Test y Print Notificacion")
    void testNotificacion() {
        Usuario u = crearUsuario(crearCurso());
        Evento e = crearEvento(u, crearCategoria(), crearLugar());
        Notificacion noti = new Notificacion();
        noti.setUsuario(u);
        noti.setEvento(e);
        noti.setTipo("RECORDATORIO");
        noti.setMensaje("El evento empieza pronto");
        noti.setLeida(false);
        noti.setFecha(new Timestamp(System.currentTimeMillis()));
        noti = notificacionRepository.save(noti);
        System.out.println("[PRINT] Notificación guardada: " + noti);
    }
}