package tests;

import main.Usuario;

import org.junit.Test;

public class UsuarioTest {
    
    @Test
    public void crear_nuevo_usuario_con_nombre_apellido_y_correo() {
        Usuario nacho = new Usuario("Nacho", "Rosales", "nacho@gmail.com");
        assertEquals("Nacho", nacho.getNombre());
        assertEquals("Rosales", nacho.getApellido());
        assertEquals("nacho@gmail.com", nacho.getDireccionCorreo());
    }

    @Test
    public void crear_usuario_y_comprobar_entrada_en_lista() {
        MailManager gestorCorreo = new MailManager(); 
        Usuario nacho = gestorCorreo.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");

        assertEquals(1, gestorCorreo.getListaUsuarios().size());
        assertEquals(nacho, gestorCorreo.getListaUsuarios().get(0));
    }

    @Test
    public void personalizar_direccion_de_correo() {
        MailManager gestorCorreo = new MailManager(); 
        Usuario nacho = gestorCorreo.crearNuevoUsuario("Nacho", "Rosales", "nacho@gmail.com");
        assertEquals("nacho@gmail.com", gestorCorreo.getListaUsuarios().get(0).getDireccionCorreo());
    }

    @Test
    public void testSetYGetCorreo() {
        Usuario nacho = new Usuario("Nacho", "Rosales", "nacho@example.com");
        nacho.setDireccionCorreo("nuevo@example.com");
        assertEquals("nuevo@example.com", nacho.getDireccionCorreo());
    }

    @Test
    public void testSetYGetApellido() {
        Usuario juani = new Usuario("Juani", "Gualtieri", "juani@example.com");
        juani.setApellido("NuevoApellido");
        assertEquals("NuevoApellido", juani.getApellido());
    }

    @Test
    public void testSetYGetNombre() {
        Usuario lourdes = new Usuario("Lourdes", "GomezSierra", "lourdes@example.com");
        lourdes.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", lourdes.getNombre());
    }

    @Test
    public void obtener_lista_de_contactos() {
        Usuario nacho = new Usuario("Nacho", "Rosales", "nacho@example.com");
        Contacto contacto1 = nacho.agregarNuevoContacto("Amigo1", "Apellido1", "amigo1@example.com");
        Contacto contacto2 = nacho.agregarNuevoContacto("Amigo2", "Apellido2", "amigo2@example.com");

        ArrayList<Contacto> listaContactos = nacho.getListaDeContactos();

        assertEquals(2, listaContactos.size());
        assertTrue(listaContactos.contains(contacto1));
        assertTrue(listaContactos.contains(contacto2));
    }

    @Test
    public void obtener_correo() {
        Usuario juani = new Usuario("Juani", "Gualtieri", "juani@example.com");
        assertEquals("juani@example.com", juani.getDireccionCorreo());
    }
}