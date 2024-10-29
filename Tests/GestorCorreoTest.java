package Tests;

import main.MailManager;

public class GestorCorreoTest {
    
    @Test
    public void comprobar_instancia_de_gestor_de_correo() {
        MailManager gestorCorreo = new MailManager();
        assertTrue(gestorCorreo instanceof MailManager);
    }
}
