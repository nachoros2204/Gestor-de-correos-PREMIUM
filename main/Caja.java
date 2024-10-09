package main;

import java.util.ArrayList;

public class Caja {
    private final ArrayList<Mail> correos = new ArrayList<>();

    public void agregarCorreo(Mail correo) {
        correos.add(correo);
    }

    public ArrayList<Mail> getTodo() {
        return correos;
    }

    // Método size() para obtener el número de correos
    public int size() {
        return correos.size();
    }
}
