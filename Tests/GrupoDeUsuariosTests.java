package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import main.GrupoDeUsuarios;
import main.MailManager;
import main.Usuario;

public class GrupoDeUsuariosTests {
    private MailManager mailManager;
    private Usuario usuario1;
    private Usuario usuario2;
    private GrupoDeUsuarios grupo;
    

    @Test
    public void testAgregarUsuarioAGrupo() {

        mailManager = new MailManager();
        grupo = new GrupoDeUsuarios ();

        usuario1 = mailManager.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");
        usuario2 = mailManager.crearNuevoUsuario("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");
        

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
        usuario2 = mailManager.crearNuevoUsuario("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");
        grupo = new GrupoDeUsuarios (); //creamos mail, usuario y grupo

        grupo.agregarUsuarioAlGrupo(usuario1); //agregamos usuarios
        grupo.agregarUsuarioAlGrupo(usuario2);

        grupo.agregarUsuarioAlGrupo(usuario1); //volvemos a agregar usuario 1

        assertEquals(2,grupo.getMiembros().size());
    }
}
