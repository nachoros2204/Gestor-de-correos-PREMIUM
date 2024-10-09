package main;

import main.Interfaces.IApellido;
import main.Interfaces.ICorreo;
import main.Interfaces.INombre;

public class Contacto implements IApellido, INombre, ICorreo {
    private final Persona persona;

    public Contacto(String nombre, String apellido, String direccionDeCorreo) {
        persona = new Persona(nombre, apellido, direccionDeCorreo);
    }

    public void setDireccionDeCorreo(String direccionDeCorreo) {
        persona.setDireccionDeCorreo(direccionDeCorreo);
    }

    public String getDireccionDeCorreo() {
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

    // Implementación del método de la interfaz IApellido
    @Override
    public String getSurname() {
        return getApellido(); // Retorna el apellido como el "surname"
    }

    @Override
    public void setDirecciondeCorreo(String direccionDeCorreo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
