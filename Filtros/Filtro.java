import Interfaces.INombre;

public class Filtro implements INombre {
    private String nombre = "";

    protected ArrayList<Correo> buscarString(String buscar, Buzon buzon) {
        return null;
    }
}

public ArrayList<Correo> filtrar (String buscarTitulo, String buscarOtro, Buzon buzon){
    buscarString(buscarTitulo, buzon);
    buscarString(buscarOtro, buzon);
    return null;
}

public ArrayList<Correo> filtrar (String buscar, Buzon buzon){
    ArrayList<Correo> correos = buscarString(buscar, buzon);
    return correos;
}

public void setNombre (String nombre){
    this.nombre = nombre;
}

public String getNombre(){
    return nombre;
}