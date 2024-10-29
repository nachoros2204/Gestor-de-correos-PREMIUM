package main;
import java.util.ArrayList;

public class GrupoDeUsuarios {
    private String nombre;
    private ArrayList<Usuario> miembros = new ArrayList<>();
    
    public GrupoDeUsuarios(String nombre) {
        this.nombre = nombre;
    }
    public void agregarUsuarioAlGrupo(Usuario usuario) {
        if (!miembros.contains(usuario)) {
            miembros.add(usuario);
        }
    }

    public ArrayList<Usuario> getMiembros() {
        return miembros;
    }
    
}