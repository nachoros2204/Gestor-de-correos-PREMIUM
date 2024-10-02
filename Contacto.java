import Interfaces.ICorreo;
import Interfaces.INombre;
import Interfaces.IApellido;

public class Contacto implements IApellido, INombre, ICorreo {
    private Persona persona = new Persona ("","","");

    
    public Contacto(String nombre, String apellido, String direccionDeCorreo){
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDireccionDeCorreo(direccionDeCorreo);
    }
    
    public void setDireccionDeCorreo(string direccionDeCorreo){
    persona.setDireccionDeCorreo(direccionDeCorreo);
    return null;
}

public string getDireccionDeCorreo(){
    return persona.getDireccionDeCorreo();
}

public void setNombre(String nombre){
    persona.setNombre(nombre);
}

public string getNombre(){
    return persona.getNombre();
}

public void setApellido(String apellido){
    persona.setApellido(apellido);
}

public string getApellido(){
    return persona.getApellido();
}

@Override
public void setDirecciondeCorreo(String direccionDeCorreo) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setDirecciondeCorreo'");
}

@Override
public String getSurname() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSurname'");
}
}