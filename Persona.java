import Interfaces.IApellido;
import Interfaces.ICorreo;
import Interfaces.INombre;

public class Persona implements INombre, IApellido, ICorreo{
    private string nombre;
    private string surname;
    private string direccionDeCorreo;

    
    public Persona(String nombre, String apellido, String direccionDeCorreo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.setDirecciondeCorreo(direccionDeCorreo);
    }
    public void setNombre(String nombre){
        this.name = name;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    