package main.Filtros;

import java.util.ArrayList;
import java.util.stream.Collectors;
import main.Mail;

public class FiltroDeRemitente extends Filtro {

    public FiltroDeRemitente() {
        super.setNombre("Filtro de Remitente");
    }

    @Override
protected ArrayList<Mail> buscarString(String buscar, ArrayList<Mail> correos) {
    // Filtra los correos que tienen el remitente que contiene el texto buscado
    return correos.stream()
             .filter(correo -> correo.getRemitente().contains(buscar))
             .collect(Collectors.toCollection(ArrayList::new)); // Colecciona los correos filtrados en un ArrayList
}

}