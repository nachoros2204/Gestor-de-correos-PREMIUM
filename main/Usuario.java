package main;

import main.Interfaces.ICorreo;
import main.Interfaces.INombre;
import main.Interfaces.IApellido;
import main.Filtros.Filtro;
import java.util.ArrayList;

public class Usuario implements INombre, IApellido, ICorreo {

    private final ArrayList<Contacto> listaDeContactos = new ArrayList<>();
    private final Caja entrada = new Caja();
    private final Caja salida = new Caja();
    private final Persona persona;

    public Usuario(String nombre, String apellido, String direccionCorreo) {
        persona = new Persona(nombre, apellido, direccionCorreo);
    }

    public void agregarCorreoAEnviados(Mail correo) {
        salida.agregarCorreo(correo);
    }

    public void agregarCorreoARecibidos(Mail correo) {
        entrada.agregarCorreo(correo);
    }

    public void setDireccionCorreo(String direccionCorreo) {
        persona.setDireccionDeCorreo(direccionCorreo);
    }

    public String getDireccionCorreo() {
        return persona.getDireccionDeCorreo();
    }

    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }

    public String getNombre() {
        return persona.getNombre();
    }

    public void setApellido(String apellido) {
        persona.setApellido(apellido);
    }

    public String getApellido() {
        return persona.getApellido();
    }

    public Caja getEntrada() {
        return entrada;
    }

    public Caja getSalida() {
        return salida;
    }

    public Contacto agregarNuevoContacto(String nombre, String apellido, String direccionDeCorreo) {
        Contacto nuevoContacto = new Contacto(nombre, apellido, direccionDeCorreo);
        listaDeContactos.add(nuevoContacto);
        return nuevoContacto;
    }

    public ArrayList<String> getTodosLosCorreosDeContactos() {
        ArrayList<String> correos = new ArrayList<>();
        for (Contacto contacto : listaDeContactos) {
            correos.add(contacto.getDireccionDeCorreo());
        }
        return correos;
    }

    public ArrayList<Contacto> getListaDeContactos() {
        return listaDeContactos; // Método que devuelve la lista de contactos
    }

    public void crearMensaje(MailManager gestorCorreo, String asunto, String mensaje, ArrayList<String> destinatarios) {
        Mail nuevoMail = new Mail(asunto, mensaje, this.getDireccionCorreo(), destinatarios);
        gestorCorreo.mandarMail(this, nuevoMail);  // Envía el correo a los destinatarios
        this.agregarCorreoAEnviados(nuevoMail);  // Añadir a la bandeja de salida
    }
    
    

    public ArrayList<Mail> filtrarEnviados(String buscar, Filtro filtro) {
        return filtro.filtrar(buscar, salida.getTodo());
    }

    public ArrayList<Mail> filtrarRecibidos(String buscar, Filtro filtro) {
        return filtro.filtrar(buscar, entrada.getTodo());
    }

    @Override
    public String getDireccionDeCorreo() {
        return persona.getDireccionDeCorreo();
    }

    @Override
    public String getSurname() {
        return persona.getApellido(); // Cambié para que devuelva el apellido
    }

    @Override
    public void setDirecciondeCorreo(String direccionDeCorreo) {
        persona.setDireccionDeCorreo(direccionDeCorreo); // Cambié para que llame al método correcto
    }
}
