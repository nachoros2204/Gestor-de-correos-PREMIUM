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
        nacho.agregarNuevoContacto("Juani", "Gualtieri", "juani@gmail.com");
        nacho.agregarNuevoContacto("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");

        ArrayList<String> contactos = nacho.getTodosLosCorreosDeContactos();
        nacho.crearMensaje(gestorCorreo, "AsuntoBuscado", "Mensaje de prueba", contactos);

        ArrayList<String> destinatarios = new ArrayList<>();
        destinatarios.add("juani@gmail.com");
        nacho.crearMensaje(gestorCorreo, "OtroAsunto", "Otro mensaje", destinatarios); 

        FiltroDeTitulo filtro = new FiltroDeTitulo();
        ArrayList<Mail> resultado = nacho.filtrarEnviados("AsuntoBuscado", filtro);
        assertEquals(1, resultado.size());
    }

    @Test
    public void filtrar_por_mensaje() {
        nacho.crearMensaje(gestorCorreo, "Mensaje a Lourdes", "Hola Lourdes", "lourdesgomezsierra@gmail.com");
        nacho.crearMensaje(gestorCorreo, "Otro mensaje a Lourdes", "Chau Lourdes", "lourdesgomezsierra@gmail.com");
     
        FiltroDeMensaje filtro = new FiltroDeMensaje();
        ArrayList<Mail> resultado = lourdes.filtrarRecibidos("Hola", filtro);
        assertEquals(1, resultado.size());
    }

    @Test
    public void filtrar_por_remitente() {
        nacho.crearMensaje(gestorCorreo, "Mensaje", "Contenido", "juani@gmail.com");
        lourdes.crearMensaje(gestorCorreo, "Otro mensaje", "Más contenido", "nacho@gmail.com");

        FiltroDeRemitente filtro = new FiltroDeRemitente();
        ArrayList<Mail> resultado = juani.filtrarRecibidos("nacho@gmail.com", filtro);
        assertEquals(1, resultado.size());
    }

    @Test
    public void filtrar_por_asunto_y_mensaje() {
        nacho.crearMensaje(gestorCorreo, "Asunto", "Mensaje", "juani@gmail.com");
        lourdes.crearMensaje(gestorCorreo, "OtroAsunto", "OtroMensaje", "nacho@gmail.com");

        FiltroDeTituloYMensaje filtro = new FiltroDeTituloYMensaje();
        ArrayList<Mail> resultado = filtro.filtrar("Asunto", "Mensaje", juani.getEntrada().getTodo());
        assertEquals(1, resultado.size());
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
