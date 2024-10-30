package main;
import java.util.ArrayList;

public class GrupoDeUsuarios {

    private ArrayList<Usuario> miembros = new ArrayList<>();
    
    public void agregarUsuarioAlGrupo(Usuario usuario) { // verifica si el usuario ya existe en la lista
        if (!miembros.contains(usuario)) {
            miembros.add(usuario);
        }
    }

    public ArrayList<Usuario> getMiembros() {
        return miembros;
    }
    
}
