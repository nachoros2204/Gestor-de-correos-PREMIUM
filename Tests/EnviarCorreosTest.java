package Tests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import main.MailManager;
import main.Usuario;


public class EnviarCorreosTest { 
    @Test
    public void crear_aplicacion_y_enviar_correo() {
        MailManager gestorCorreo = new MailManager(); 
        Usuario nacho = gestorCorreo.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");
        Usuario lourdes = gestorCorreo.crearNuevoUsuario("Lourdes", "GomezSierra", "lourdesgomezsierra@gmail.com");
        Usuario juani = gestorCorreo.crearNuevoUsuario("Juani", "Gualtieri", "juani@gmail.com");

        ArrayList<String> para = new ArrayList<>();
        para.add("lourdesgomezsierra@gmail.com");
        para.add("juani@gmail.com");

        nacho.crearMensaje(gestorCorreo, "Saludos", "Hola, ¿cómo están?", para);

        assertEquals(1, nacho.getSalida().size());
        assertEquals(1, lourdes.getEntrada().size());
        assertEquals(1, juani.getEntrada().size());
    }
}