package main;
import java.util.ArrayList;
import java.util.List;

public class MailManager {
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<GrupoDeUsuarios> listaGrupos = new ArrayList<>();

public Usuario crearNuevoUsuario(String nombre, String apellido, String direccionCorreo){
    Usuario usuario = new Usuario(nombre, apellido, direccionCorreo);
    agregarUsuarioALaLista(usuario);
    return usuario;
}

public void mandarMail(Usuario remitente, Mail correo, GrupoDeUsuarios grupo) {
    System.out.println("Iniciando el proceso de envío de correo");

    ArrayList<String> direccionesCorreo = new ArrayList<>(correo.getDestinatario());
    if (grupo != null) {
        for (Usuario usuario : grupo.getMiembros()) {
            String direccion = usuario.getDireccionCorreo();
            if (!direccionesCorreo.contains(direccion)) {
                direccionesCorreo.add(direccion);
            }
        }
    }

    correo.setDestinatario(direccionesCorreo);
    System.out.println("Destinatarios actualizados: " + direccionesCorreo);

    ArrayList<Usuario> usuariosCoinciden = buscarUsuariosPorCorreos(direccionesCorreo);
    System.out.println("Usuarios coincidentes encontrados: " + usuariosCoinciden.size());

    remitente.agregarCorreoAEnviados(correo.clonar());
    System.out.println("Correo agregado a la bandeja de enviados del remitente");

    for (Usuario usuario : usuariosCoinciden) {
        usuario.agregarCorreoARecibidos(correo.clonar());
        System.out.println("Correo agregado a la bandeja de entrada de: " + usuario.getDireccionCorreo());
    }
}


private ArrayList<Usuario> buscarUsuariosPorCorreos(ArrayList<String> correos) {
    ArrayList<Usuario> usuariosCoinciden = new ArrayList<>();
    for (Usuario usuario : listaUsuarios) {
        if (correos.contains(usuario.getDireccionCorreo())) {
            usuariosCoinciden.add(usuario);
        }
    }
    return usuariosCoinciden;
}

public void agregarUsuarioALaLista(Usuario nuevoUsuario) {
    listaUsuarios.add(nuevoUsuario);
}

//Para propósitos de prueba
public ArrayList<Usuario> getListaUsuarios() {
    return listaUsuarios;
}

public void agregarGrupo(GrupoDeUsuarios grupo) {
    listaGrupos.add(grupo);
}

public List<GrupoDeUsuarios> getListaGrupos() {
    return listaGrupos;
}
}
