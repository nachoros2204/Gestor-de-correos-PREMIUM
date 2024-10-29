package Tests;

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
public void testSetGetApellido() {
    Contacto contacto = new Contacto("Juani", "Gualtieri", "juani@gmail.com");
    
    contacto.setApellido("NuevoApellido");
    assertEquals("NuevoApellido", contacto.getApellido());
}



}
