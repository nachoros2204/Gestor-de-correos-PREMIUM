package main;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailManager {
    private final ArrayList<Usuario> listaUsuarios = new ArrayList<>();

public void mandarMail(Usuario remitente, Mail correo){
    ArrayList<String> direccionesCorreo = correo.getDestinatario();
    List<Usuario> usuariosCoinciden = buscarUsuariosPorCorreos(direccionesCorreo);
    remitente.agregarCorreoAEnviados(correo.clonar());   //Agrega el correo a la bandeja de enviados del remitente


    for(Usuario usuario : usuariosCoinciden){
        usuario.agregarCorreoARecibidos(correo.clonar());    //Agrega el correo a la bandeja de recibidos del destinatario
    }
}

private List<Usuario> buscarUsuariosPorCorreos(ArrayList<String> correos) {
    List <Usuario> usuariosCoinciden = listaUsuarios.stream()
    .filter(usuario -> correos.stream()
        .anyMatch(correo -> usuario.getDireccionCorreo().equals(correo)))
    .collect(Collectors.toList());

    return usuariosCoinciden;
}

public void agregarUsuarioALaLista(Usuario nuevoUsuario) {
    listaUsuarios.add(nuevoUsuario);
}

public Usuario crearNuevoUsuario(String nombre, String apellido, String direccionCorreo){
    Usuario usuario = new Usuario(nombre, apellido, direccionCorreo);
    agregarUsuarioALaLista(usuario);
    return usuario;
}

//Para propósitos de prueba
public ArrayList<Usuario> getListaUsuarios() {
    return listaUsuarios;
}

public void mandarMailAGrupo(Usuario remitente, Mail correo, GrupoDeUsuarios grupo) {
    remitente.agregarCorreoAEnviados(correo);  // Agrega el correo a enviados del remitente

    for (Usuario usuario : grupo.getMiembros()) {
        usuario.agregarCorreoARecibidos(correo);  // Agrega el correo a recibidos de cada miembro
    }
}

private final ArrayList<GrupoDeUsuarios> listaGrupos = new ArrayList<>();
public void agregarGrupo(GrupoDeUsuarios grupo) {
    listaGrupos.add(grupo);
}

public List<GrupoDeUsuarios> getListaGrupos() {
    return listaGrupos;
}
}
