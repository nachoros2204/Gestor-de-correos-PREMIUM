package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Contacto;

public class ContactoTests {
    @Test
    
    public void testCrearContacto(){
        Contacto contacto = new Contacto("Lourdes","GomezSierra","lourdesgomezsierra@gmail.com");
        assertEquals("Lourdes",contacto.getNombre());
        assertEquals("GomezSierra",contacto.getApellido());
        assertEquals("lourdesgomezsierra@gmail.com",contacto.getDireccionDeCorreo());
    }
    @Test
    public void testGetSetDireccionDeCorreo(){
    Contacto contacto = new Contacto ("Maria", "Lopez", "marialopez@gmail.com");
    
    contacto.setDireccionDeCorreo("marialopez@gmail.com");
    assertEquals("marialopez@gmail.com", contacto.getDireccionDeCorreo());
}
@Test
public void testSetNombreGetNombre() {
    Contacto contacto = new Contacto("Nacho", "Rosales", "nacho@gmail.com");
    
    contacto.setNombre("NuevoNombre");
    assertEquals("NuevoNombre", contacto.getNombre());
}

@Test
public void testSetGetNombre() {
    Contacto contacto = new Contacto("Juan", "Johnson", "juane@gmail.com");
    
    contacto.setApellido("NuevoApellido");
    assertEquals("NuevoApellido", contacto.getApellido());
}



}
