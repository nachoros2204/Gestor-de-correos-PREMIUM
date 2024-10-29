package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import main.GrupoDeUsuarios;
import main.Mail;
import main.MailManager;
import main.Usuario;

public class GrupoDeUsuariosTests {
    private MailManager mailManager;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private GrupoDeUsuarios grupo;

    @BeforeEach
    public void setUp() {
        mailManager = new MailManager();
        usuario1 = mailManager.crearNuevoUsuario("John", "Doe", "john@example.com");
        usuario2 = mailManager.crearNuevoUsuario("Jane", "Smith", "jane@example.com");
        usuario3 = mailManager.crearNuevoUsuario("Alice", "Johnson", "alice@example.com");

        grupo = new GrupoDeUsuarios("Amigos");
        grupo.agregarUsuarioAlGrupo(usuario1);
        grupo.agregarUsuarioAlGrupo(usuario2);
        mailManager.agregarGrupo(grupo);
    }

    @Test
    public void testAgregarUsuarioAGrupo() {
        assertTrue(grupo.getMiembros().contains(usuario1), "El grupo debería contener a usuario1");
        assertTrue(grupo.getMiembros().contains(usuario2), "El grupo debería contener a usuario2");
    }

    @Test
    public void testAgregarUsuarioExistenteAlGrupo() {
        grupo.agregarUsuarioAlGrupo(usuario1);
        assertEquals(2, grupo.getMiembros().size(), "El grupo no debería duplicar usuarios ya existentes");
    }

    @Test
    public void testMandarMailAGrupo() {
        Mail correo = new Mail("Asunto", "Contenido", "john@example.com", new ArrayList<>());
        mailManager.mandarMailAGrupo(usuario1, correo, grupo);

        assertTrue(usuario1.getCorreosEnviados().contains(correo), "Usuario1 debería tener el correo en enviados");
        assertTrue(usuario2.getCorreosRecibidos().contains(correo), "Usuario2 debería tener el correo en recibidos");
    }

    @Test
    public void testMandarMailAGrupoConNuevoUsuario() {
        grupo.agregarUsuarioAlGrupo(usuario3);
        
        Mail correo = new Mail("Asunto Nuevo", "Contenido Nuevo", "john@example.com", new ArrayList<>());
        mailManager.mandarMailAGrupo(usuario1, correo, grupo);

        assertTrue(usuario3.getCorreosRecibidos().contains(correo), "Usuario3 debería tener el correo en recibidos");
    }
}
