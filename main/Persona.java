package main;
import main.interfaces.IApellido;
import main.interfaces.ICorreo;
import main.interfaces.INombre;

public class Persona implements INombre, IApellido, ICorreo{
    private String nombre;
    private String apellido;
    private String direccionDeCorreo;
    
    public Persona(String nombre, String apellido, String direccionDeCorreo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.setDireccionDeCorreo(direccionDeCorreo);
    }
    public void setNombre(String nombre){ //para establecer el nombre
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){//para establecer el apellido
        this.apellido = apellido;
    }
    
public void setDireccionDeCorreo(String direccionDeCorreo){//para establecer el correo

if(direccionDeCorreo.contains("@")){ // si no contiene arroba, pone arrobagmailptocom
    this.direccionDeCorreo = direccionDeCorreo;
    
} else {
    this.direccionDeCorreo = direccionDeCorreo + "@gmail.com";
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