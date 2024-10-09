package main.Filtros;

import java.util.ArrayList;
import java.util.stream.Collectors;

import main.Mail;

public class FiltroDeMensaje extends Filtro {
    
    public FiltroDeMensaje() {
        super.setNombre("Filtro de Mensaje");
    }

    @Override
    protected ArrayList<Mail> buscarString (String buscar, ArrayList<Mail> correos) {
        // Filtra los correos que contienen el texto buscado en el mensaje
        return correos.stream()
            .filter(correo -> correo.getMensaje().contains(buscar))
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
