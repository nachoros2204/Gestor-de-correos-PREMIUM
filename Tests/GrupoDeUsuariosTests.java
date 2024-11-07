package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
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

    @Before
    public void setUp() {
        mailManager = new MailManager();
        usuario1 = mailManager.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");
        usuario2 = mailManager.crearNuevoUsuario("Lourdes", "Gomez", "lourdes@gmail.com");
        usuario3 = mailManager.crearNuevoUsuario("Juani", "Gualtieri", "juani@gmail.com");

        grupo = new GrupoDeUsuarios ();
        grupo.agregarUsuarioAlGrupo(usuario1);
        grupo.agregarUsuarioAlGrupo(usuario2);
        mailManager.agregarGrupo(grupo);
    }

    @Test
    public void testAgregarUsuarioAGrupo() {
        assertTrue(grupo.getMiembros().contains(usuario1));
        assertTrue(grupo.getMiembros().contains(usuario2));
    }

    @Test
    public void testAgregarUsuarioExistenteAlGrupo() {
        grupo.agregarUsuarioAlGrupo(usuario1);
        assertEquals(2,grupo.getMiembros().size());
    }

    @Test
    public void testMandarMailAGrupo() {
        Mail correo = new Mail("Asunto", "Contenido", "nacho@gmail.com", new ArrayList<>());
        
        //correo.agregar(usuario1);
        //correo.agregar(usuario3);

        //correo.agregar(grupoNumero6);

        //em1.enviar(correo):

        mailManager.mandarMailAGrupo(usuario1, correo, grupo);

        assertTrue("Usuario1 debería tener el correo en enviados",usuario1.getSalida().contieneCorreo(correo));
        assertTrue("Usuario2 debería tener el correo en recibidos", usuario1.getEntrada().contieneCorreo(correo));
        assertTrue("Usuario2 debería tener el correo en recibidos", usuario2.getEntrada().contieneCorreo(correo));
    }

    @Test
    public void testMandarMailAGrupoConNuevoUsuario() {
        grupo.agregarUsuarioAlGrupo(usuario3);
        
        Mail correo = new Mail("Asunto Nuevo", "Contenido Nuevo", "juani@gmail.com", new ArrayList<>());
        mailManager.mandarMailAGrupo(usuario1, correo, grupo);

        assertTrue("Usuario3 debería tener el correo en recibidos", usuario3.getEntrada().contieneCorreo(correo));
    }
}
