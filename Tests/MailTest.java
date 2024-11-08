package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Mail;
import main.MailManager;
import main.Usuario;

public class MailTest {

    @Test
    public void testMarcarComoFavorito() {
        ArrayList<String> destinatario = new ArrayList<>();
        destinatario.add("nacho@gmail.com");

        Mail correo = new Mail("Asunto", "mensaje", "lourdes@gmail.com", destinatario);

        
        assertFalse(correo.esFavorito());

        
        correo.marcarComoFavorito();
        assertTrue(correo.esFavorito());

        
        correo.marcarComoFavorito();
        assertFalse(correo.esFavorito());
    }

    @Test
    public void testObtenerCorreosFavoritos() {
        MailManager gestorCorreo = new MailManager();
        Usuario usuario = gestorCorreo.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");

        // Crear correos y agregar a la salida del usuario
        ArrayList<String> destinatario = new ArrayList<>();
        destinatario.add("lourdes@gmail.com");

        Mail correo1 = new Mail("Asunto 1", "mensaje 1", "nacho@gmail.com", destinatario);
        Mail correo2 = new Mail("Asunto 2", "mensaje 2", "nacho@gmail.com", destinatario);
        
        // Marcar el primer correo como favorito
        correo1.marcarComoFavorito();

        // Agregar correos a la bandeja de salida del usuario
        usuario.agregarCorreoAEnviados(correo1);
        usuario.agregarCorreoAEnviados(correo2);

        // Obtener los correos favoritos del usuario y verificar que solo contiene el favorito
        List<Mail> correosFavoritos = gestorCorreo.obtenerCorreosFavoritos(usuario);
        assertEquals(1, correosFavoritos.size());
        assertTrue(correosFavoritos.contains(correo1));
        assertFalse(correosFavoritos.contains(correo2));
    }
}
