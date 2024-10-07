package main;

import GestorCorreo.Filtros.*;
import GestorCorreo.Interfaces.IDireccion;
import GestorCorreo.Interfaces.INombre;
import GestorCorreo.Interfaces.IApellido;

import java.util.ArrayList;

public class Usuario implements INombre, IApellido, IDireccion {

    private ArrayList<Contacto> listaDeContactos = new ArrayList<>();
    private Bandeja entrada = new Bandeja();
    private Bandeja salida = new Bandeja();

    private Persona persona = new Persona("", "", "");

    }

    public Usuario (String nombre, String apellido, String direccionCorreo){
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDireccionCorreo(direccionCorreo);
    }

    public void setDireccionCorreo (String direccionCorreo){
        persona.setDireccionCorreo(direccionCorreo);
    }

    public String getDireccionCorreo(){
        return persona.getDireccionCorreo();
    }

    public void setNombre (String nombre){
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