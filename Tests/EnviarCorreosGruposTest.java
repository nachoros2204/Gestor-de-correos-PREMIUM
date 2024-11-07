package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import main.GrupoDeUsuarios;
import main.Mail;
import main.MailManager;
import main.Usuario;

public class EnviarCorreosGruposTest {

    private MailManager mailManager;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private GrupoDeUsuarios grupo;

    @Test
    public void testMandarMailAGrupoYUsuarios() {
        // Inicialización
        mailManager = new MailManager();
        usuario1 = mailManager.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");
        usuario2 = mailManager.crearNuevoUsuario("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");
        usuario3 = mailManager.crearNuevoUsuario("Juani", "Gualtieri", "juani@gmail.com");
        grupo = new GrupoDeUsuarios(); // Crear grupo

        // Agregar usuarios al grupo
        grupo.agregarUsuarioAlGrupo(usuario2);
        grupo.agregarUsuarioAlGrupo(usuario3);

        //correo.agregar(usuario1);
        //correo.agregar(usuario3);

        //correo.agregar(grupoNumero6);

        //em1.enviar(correo): (especificaciones del profe)

        // Crear correo
        Mail correo = new Mail("Asunto", "Contenido", "nacho@gmail.com", new ArrayList<>());

        // Mandar correo a grupo
        mailManager.mandarMail(usuario1, correo, grupo);

        // Verificar que el correo esté en la bandeja de salida del remitente
        assertTrue("Usuario1 debería tener el correo en enviados", usuario1.getSalida().contieneCorreo(correo));
        
        // Verificar que el correo esté en la bandeja de entrada de los destinatarios
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

