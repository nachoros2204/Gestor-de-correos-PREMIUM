import java.util.ArrayList;
import GestorCorreo.*;
import java.util.stream.Collectors;

import Filtro.Filtro;

public class FiltroDeTitulo extends Filtro {

    public FiltroDeTitulo() {
        super.setNombre("Filtro de Asunto");
    }

    @Override
     protected ArrayList<Correo> buscarString(String buscar, Buzon buzon) {
          ArrayList<Correo> correos = buzon.getTodo().stream()
                  .filter(correo -> correo.getTitulo().contains(buscar))
                  .collect(Collectors.toCollection(ArrayList::new)); // Colecciona los correos filtrados en un ArrayList
          return correos; // Retorna el ArrayList con los correos filtrados
      }
}