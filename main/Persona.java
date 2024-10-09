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
        this.setDireccionDeCorreo(direccionDeCorreo);
    }
    public void setNombre(String nombre){ //para establedcer el nombre
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){//para establedcer el apellido
        this.apellido = apellido;
    }
    
public void setDireccionDeCorreo(String direccionDeCorreo){//para establedcer el correo

if(direccionDeCorreo.contains("@")){ // si no contiene arroba, pone arrobaucpptocom
    this.direccionDeCorreo = direccionDeCorreo;
    
} else {
    this.direccionDeCorreo = direccionDeCorreo + "@ucp.com";
}
}

public String getNombre(){
    return nombre;
}
public String getApellido(){
    return apellido;
}
public String getDireccionDeCorreo(){
    return direccionDeCorreo;

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