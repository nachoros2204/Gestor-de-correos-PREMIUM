package tests;

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
    

    @Test
    public void testAgregarUsuarioAGrupo() {

        mailManager = new MailManager();
        grupo = new GrupoDeUsuarios ();

        grupo.agregarUsuarioAlGrupo(usuario1);
        grupo.agregarUsuarioAlGrupo(usuario2);
        mailManager.agregarGrupo(grupo);

        assertTrue(grupo.getMiembros().contains(usuario1));
        assertTrue(grupo.getMiembros().contains(usuario2));
    }

    @Test
    public void testAgregarUsuarioExistenteAlGrupo() {

        mailManager = new MailManager();
        usuario1 = mailManager.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com"); 
        grupo = new GrupoDeUsuarios (); //creamos mail, usuario y grupo

        grupo.agregarUsuarioAlGrupo(usuario1); //agregamos usuarios
        grupo.agregarUsuarioAlGrupo(usuario2);

        grupo.agregarUsuarioAlGrupo(usuario1); //volvemos a agregar usuario 1

        assertEquals(2,grupo.getMiembros().size());
    }

    @Test
    public void testMandarMailAGrupoYUsuarios() {

        Mail correo = new Mail("Asunto", "Contenido", "nacho@gmail.com", new ArrayList<>());
        MailManager mailManager = new MailManager(); 

        Usuario usuario1 = mailManager.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");
        Usuario usuario2 = mailManager.crearNuevoUsuario("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");
        Usuario usuario3 = mailManager.crearNuevoUsuario("Juani", "Gualtieri", "juani@gmail.com");

        grupo = new GrupoDeUsuarios (); //creamos todo

        grupo.agregarUsuarioAlGrupo(usuario2); //agregamos usuarios a grupo
        grupo.agregarUsuarioAlGrupo(usuario3);

        //correo.agregar(usuario1);
        //correo.agregar(usuario3);

        //correo.agregar(grupoNumero6);

        //em1.enviar(correo): (especificaciones del profe)

        mailManager.mandarMail(usuario1, correo, grupo);

        assertTrue("Usuario1 debería tener el correo en enviados",usuario1.getSalida().contieneCorreo(correo));
        assertTrue("Usuario2 debería tener el correo en recibidos", usuario2.getEntrada().contieneCorreo(correo));
        assertTrue("Usuario3 debería tener el correo en recibidos", usuario3.getEntrada().contieneCorreo(correo));
    }

    @Test
    public void testMandarMailAGrupoConNuevoUsuario() {
        grupo.agregarUsuarioAlGrupo(usuario3);
        
        Mail correo = new Mail("Asunto Nuevo", "Contenido Nuevo", "juani@gmail.com", new ArrayList<>());
        mailManager.mandarMail(usuario1, correo, grupo);

        assertTrue("Usuario3 debería tener el correo en recibidos", usuario3.getEntrada().contieneCorreo(correo));
    }
}
