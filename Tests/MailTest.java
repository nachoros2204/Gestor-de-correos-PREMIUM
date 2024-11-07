package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import main.Mail;

public class MailTest {
    @Test
    public void testTestMarcarComoFavorito() {
            ArrayList<String> destinatario = new ArrayList<>();
            destinatario.add("nacho@gmail.com");
        
            Mail correo = new Mail ("Asunto", "mensaje", "lourdes@gmail.com", destinatario);
        
            assertFalse(correo.esFavorito());
    
            correo.marcarComoFavorito();
            assertTrue(correo.esFavorito());
        
            correo.marcarComoFavorito();
            assertFalse(correo.esFavorito());
        
        }
    }
