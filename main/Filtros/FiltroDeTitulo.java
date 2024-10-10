package main.Filtros;

import java.util.ArrayList;
import java.util.stream.Collectors;
import main.Mail;

public class FiltroDeTitulo extends Filtro {

    public FiltroDeTitulo() {
        super.setNombre("Filtro de Asunto");
    }

    @Override
     protected ArrayList<Mail> buscarString(String buscar, ArrayList<Mail> correos) {
       // Filtra los correos que tienen el remitente que contiene el texto buscado
        return correos.stream()
        .filter(correo -> correo.getTitulo().contains(buscar))
        .collect(Collectors.toCollection(ArrayList::new)); // Colecciona los correos filtrados en un ArrayList
}
}