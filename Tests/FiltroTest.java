package Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import main.Filtros.*;
import main.Mail;
import main.MailManager;
import main.Usuario;

import java.util.ArrayList;

public class FiltroTest {

    MailManager gestorCorreo = new MailManager(); 
    Usuario nacho = gestorCorreo.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");
    Usuario lourdes = gestorCorreo.crearNuevoUsuario("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");
    Usuario juani = gestorCorreo.crearNuevoUsuario("Juani", "Gualtieri", "juani@gmail.com");

    @Test
    public void filtrar_por_asunto() {
        // Agrega contactos
        nacho.agregarNuevoContacto("Juani", "Gualtieri", "juani@gmail.com");
        nacho.agregarNuevoContacto("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");

        // Crea y envia mensajes
        ArrayList<String> contactos = nacho.getTodosLosCorreosDeContactos();
        nacho.crearMensaje(gestorCorreo, "AsuntoBuscado", "Mensaje de prueba", contactos);
        
        // Tambien envia otro mensaje con el mismo asunto
        ArrayList<String> destinatarios = new ArrayList<>();
        destinatarios.add("juani@gmail.com");
        nacho.crearMensaje(gestorCorreo, "AsuntoBuscado", "Otro mensaje", destinatarios);

        // Filtra por asunto
        FiltroDeTitulo filtro = new FiltroDeTitulo();
        ArrayList<Mail> resultado = nacho.filtrarEnviados("AsuntoBuscado", filtro);

        assertEquals(2, resultado.size());  // Se espera 2 mensajes
    }

    @Test
    public void filtrar_por_mensaje() {
        // Crear y enviar mensajes
        ArrayList<String> destinatarios = new ArrayList<>();
        destinatarios.add("lourdesgomezsierra@gmail.com");
        nacho.crearMensaje(gestorCorreo, "Mensaje a Lourdes", "Hola Lourdes", destinatarios);
        nacho.crearMensaje(gestorCorreo, "Otro mensaje a Lourdes", "Chau Lourdes", destinatarios);

        // Filtrar por mensaje
        FiltroDeMensaje filtro = new FiltroDeMensaje();
        ArrayList<Mail> resultado = lourdes.filtrarRecibidos("Hola", filtro);

        assertEquals(1, resultado.size());  
    }

    @Test
    public void filtrar_por_remitente() {
        // Crear mensajes
        ArrayList<String> destinatarios1 = new ArrayList<>();
        destinatarios1.add("juani@gmail.com");
        nacho.crearMensaje(gestorCorreo, "Mensaje", "Contenido", destinatarios1);

        ArrayList<String> destinatarios2 = new ArrayList<>();
        destinatarios2.add("nacho@gmail.com");
        lourdes.crearMensaje(gestorCorreo, "Otro mensaje", "Más contenido", destinatarios2);

        // Filtrar por remitente
        FiltroDeRemitente filtro = new FiltroDeRemitente();
        ArrayList<Mail> resultado = juani.filtrarRecibidos("nacho@gmail.com", filtro);

        assertEquals(1, resultado.size());  
    }

    @Test
    public void filtrar_por_asunto_y_mensaje() {
        // Crear mensajes
        ArrayList<String> destinatarios = new ArrayList<>();
        destinatarios.add("juani@gmail.com");
        nacho.crearMensaje(gestorCorreo, "Asunto", "Mensaje", destinatarios);
        lourdes.crearMensaje(gestorCorreo, "OtroAsunto", "Mensaje", destinatarios);

        // Filtrar por asunto y mensaje
        FiltroDeTituloYMensaje filtro = new FiltroDeTituloYMensaje();
        ArrayList<Mail> resultado = filtro.filtrar("Asunto", "Mensaje", juani.getEntrada().getTodo());

        assertEquals(1, resultado.size());  // Se espera 1 mensaje
    }

    @Test
    public void nombres_de_filtros() {
        FiltroDeRemitente filtroRemitente = new FiltroDeRemitente();
        FiltroDeMensaje filtroMensaje = new FiltroDeMensaje();
        FiltroDeTitulo filtroAsunto = new FiltroDeTitulo();

        String nombreFiltroRemitente = filtroRemitente.getNombre();
        String nombreFiltroMensaje = filtroMensaje.getNombre();
        String nombreFiltroAsunto = filtroAsunto.getNombre();

        assertEquals("Filtro de Remitente", nombreFiltroRemitente);
        assertEquals("Filtro de Mensaje", nombreFiltroMensaje);
        assertEquals("Filtro de Asunto", nombreFiltroAsunto);
    }
}
