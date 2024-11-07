package main;

import java.util.ArrayList;

public class Caja {
    private final ArrayList<Mail> correos = new ArrayList<>();

    public void agregarCorreo(Mail correo) {
        correos.add(correo);
        System.out.println("Correo agregado: " + correo.getTitulo());
    }

    public ArrayList<Mail> getTodo() {
        return correos;
    }

    // metodo size() para obtener el número de correos
    public int size() {
        return correos.size();
    }

    // metodo para verificar si existe el correo
    public boolean contieneCorreo(Mail correo) {
        boolean contiene = correos.contains(correo);
            System.out.println("Verificación de contieneCorreo: " + contiene);
            return contiene;
    }  
}
