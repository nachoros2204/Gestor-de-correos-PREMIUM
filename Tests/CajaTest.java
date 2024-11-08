package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Caja;
import main.Mail;

public class CajaTest {

    @Test
    public void testAgregarYObtenerCorreo() {
        Caja caja = new Caja();
        ArrayList<String> para = new ArrayList<>();
        para.add("juani@gmail.com");
        
        Mail correo1 = new Mail("Correo 1", "Mensaje 1", "nacho@gmail.com", para);
        Mail correo2 = new Mail("Correo 2", "Mensaje 2", "nacho@gmail.com", para);

        caja.agregarCorreo(correo1);
        caja.agregarCorreo(correo2);

        assertEquals(2, caja.getTodo().size());
        assertEquals(correo1, caja.getTodo().get(0));
        assertEquals(correo2, caja.getTodo().get(1));
    }

    @Test
    public void testObtenerTodosLosCorreos() {
        Caja caja = new Caja();
        ArrayList<String> para = new ArrayList<>();
        para.add("juani@gmail.com");
        
        Mail correo1 = new Mail("Correo 1", "Mensaje 1", "nacho@gmail.com", para);
        Mail correo2 = new Mail("Correo 2", "Mensaje 2", "nacho@gmail.com", para);

        caja.agregarCorreo(correo1);
        caja.agregarCorreo(correo2);

        List<Mail> todosLosCorreos = caja.getTodo();

        assertEquals(2, todosLosCorreos.size());
        assertTrue(todosLosCorreos.contains(correo1));
        assertTrue(todosLosCorreos.contains(correo2));
    }

    @Test
    public void testTamañoCajaVacia() {
        Caja caja = new Caja();
        assertEquals(0, caja.getTodo().size());
    }
}