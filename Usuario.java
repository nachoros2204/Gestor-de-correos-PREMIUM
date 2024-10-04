package GestorCorreo;

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