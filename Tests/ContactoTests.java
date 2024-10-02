package Tests;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactoTests {
    @Test
    
    public void testSetGetDireccionDeCorreo(){
        Contacto contacto = new Contacto("Lourdes","GomezSierra","lourdesgomezsierra@gmail.com");
        contacto.setDireccionDeCorreo("lourdesgomezsierra@gmail.com");
        assertEquals("Lourdes",contacto.getNombre());
        assertEquals("GomezSierra",contacto.getApellido());
        assertEquals("lourdesgomezsierra@gmail.com",contacto.getDireccionDeCorreo());
    }
}
//FALTA 