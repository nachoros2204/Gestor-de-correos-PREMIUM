import java.util.ArrayList;
import java.util.stream.Collectors;

public class FiltroDeMensaje extends Filtro {
    
    public FiltroDeMensaje() {
        super.setNombre("Filtro de Mensaje");
    }

    @Override
    protected ArrayList<Correo> buscarString (String buscar, Buzon buzon) {
        ArrayList<Correo> correos = buzon.getTodo().stream()
            .filter(correo -> correo.getMensaje().contains(buscar))
            .collect(Collectors.toCollection(ArrayList::new));
        return correos;
    }
}
