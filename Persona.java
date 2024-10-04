import Interfaces.IApellido;
import Interfaces.ICorreo;
import Interfaces.INombre;

public class Persona implements INombre, IApellido, ICorreo{
    private String nombre;
    private String surname;
    private String direccionDeCorreo;

    
    public Persona(String nombre, String apellido, String direccionDeCorreo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.setDirecciondeCorreo(direccionDeCorreo);
    }
    public void setNombre(String nombre){ //para establedcer el nombre
        this.name = name;
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
return null; }