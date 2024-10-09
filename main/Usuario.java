package main;

import main.Interfaces.ICorreo;
import main.Interfaces.INombre;
import main.Interfaces.IApellido;

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

    @Override
    public String getDireccionDeCorreo() {
        return persona.getDireccionDeCorreo();
    }

    @Override
    public String getSurname() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDirecciondeCorreo(String direccionDeCorreo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}