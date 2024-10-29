package main;

import main.Interfaces.IApellido;
import main.Interfaces.ICorreo;
import main.Interfaces.INombre;

public class Contacto implements IApellido, INombre, ICorreo {
    private final Persona persona;

    public Contacto(String nombre, String apellido, String direccionDeCorreo) {
        persona = new Persona(nombre, apellido, direccionDeCorreo);
    }

    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public String getApellido() {
        return persona.getApellido();
    }

    @Override
    public String getDireccionDeCorreo() {
        return persona.getDireccionDeCorreo();
    }

    @Override
    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }

    

    @Override
    public void setApellido(String apellido) {
        persona.setApellido(apellido);
    }

   

    @Override
    public void setDireccionDeCorreo(String direccionDeCorreo) {
        persona.setDireccionDeCorreo(direccionDeCorreo);
    }
}
