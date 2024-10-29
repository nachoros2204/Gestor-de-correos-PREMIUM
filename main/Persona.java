package main;

import main.Interfaces.IApellido;
import main.Interfaces.ICorreo;
import main.Interfaces.INombre;

public class Persona implements INombre, IApellido, ICorreo{
    private String nombre;
    private String apellido;
    private String direccionDeCorreo;
    
    public Persona(String nombre, String apellido, String direccionDeCorreo){
        this.nombre = nombre;
        this.apellido = apellido;

        //Se vuelve a repetir mas abajo para no llamar al metodo setDireccionDeCorreo, por posibles problemas de logica
        if(direccionDeCorreo.contains("@")){ // si no contiene arroba, pone arrobagmailptocom
            this.direccionDeCorreo = direccionDeCorreo;
            
        } else {
            this.direccionDeCorreo = direccionDeCorreo + "@gmail.com";
        }
    }


    @Override
    public String getNombre(){
        return nombre;
    }

    @Override
    public String getApellido(){
        return apellido;
    }

    @Override
    public String getDireccionDeCorreo(){
        return direccionDeCorreo;
    }

    @Override
    public void setNombre(String nombre){ //para establecer el nombre
        this.nombre = nombre;
    }
    
    @Override
    public void setApellido(String apellido){//para establecer el apellido
        this.apellido = apellido;
    }
    
    

    @Override
    public void setDireccionDeCorreo(String direccionDeCorreo) {
        if(direccionDeCorreo.contains("@")){ // si no contiene arroba, pone arrobagmailptocom
            this.direccionDeCorreo = direccionDeCorreo;
            
        } else {
            this.direccionDeCorreo = direccionDeCorreo + "@gmail.com";
        }
    }
}