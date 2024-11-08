package main.Filtros;

import java.util.ArrayList;

import main.Mail;
import main.Interfaces.INombre;

public class Filtro implements INombre {
    private String nombre = "";
    protected ArrayList<Mail> buscarString(String buscar, ArrayList<Mail> correos) {
        ArrayList<Mail> resultados = new ArrayList<>();
        for (Mail correo : correos) {  // Usamos la lista de correos directamente
            if (correo.getTitulo().contains(buscar) || correo.getMensaje().contains(buscar)) {
                resultados.add(correo);
            }
        }
        return resultados;
}
// Metodo para filtrar correos segun multiples criterios
public ArrayList<Mail> filtrar(String buscarTitulo, String buscarOtro, ArrayList<Mail> correos) {
    ArrayList<Mail> resultados = new ArrayList<>();
    resultados.addAll(buscarString(buscarTitulo, correos));
    resultados.addAll(buscarString(buscarOtro, correos));
    return resultados;
}
// Metodo para filtrar correos segun un solo criterio
public ArrayList<Mail> filtrar(String buscar, ArrayList<Mail> correos) {
    return buscarString(buscar, correos);
}
// Metodos de la interfaz INombre
    @Override
    public void setNombre (String nombre){
    this.nombre = nombre;
}
    @Override
    public String getNombre(){
    return nombre;
}
} 