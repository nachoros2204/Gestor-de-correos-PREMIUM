package main;

import java.util.ArrayList;
import java.util.List;

public class MailManager {
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<GrupoDeUsuarios> listaGrupos = new ArrayList<>();

    public void mandarMail(Usuario remitente, Mail correo, GrupoDeUsuarios grupo) {
        //creamos una lista para almacenar todos los destinatarios
        ArrayList<String> direccionesCorreo = new ArrayList<>(correo.getDestinatario());
        //agregamos direcciones de los miembros del grupo, si el grupo no es nulo
        if (grupo != null) {
            for (Usuario usuario : grupo.getMiembros()) {
                String direccion = usuario.getDireccionCorreo();
                //solo agregamos si el correo aún no está en la lista
                if (!direccionesCorreo.contains(direccion)) {
                    direccionesCorreo.add(direccion);
                }
            }
        }

        //actualizamos los destinatarios del correo
        correo.setDestinatario(direccionesCorreo);

        //buscamos usuarios coincidentes con las direcciones
        ArrayList<Usuario> usuariosCoinciden = buscarUsuariosPorCorreos(direccionesCorreo);
        remitente.agregarCorreoAEnviados(correo.clonar()); // Agregar a enviados del remitente

        //entregamos el correo a cada destinatario
        for (Usuario usuario : usuariosCoinciden) {
            usuario.agregarCorreoARecibidos(correo.clonar());
        }
    }

    public Usuario crearNuevoUsuario(String nombre, String apellido, String direccionCorreo) {
        Usuario usuario = new Usuario(nombre, apellido, direccionCorreo);
        agregarUsuarioALaLista(usuario);
        return usuario;
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

    // Método para obtener solo los correos favoritos del usuario remitente
    public List<Mail> obtenerCorreosFavoritos(Usuario usuario) {
        ArrayList<Mail> correosFavoritos = new ArrayList<>();
        for (Mail correo : usuario.getSalida().getTodo()) {
            if (correo.esFavorito()) {
                correosFavoritos.add(correo);
            }
        }
        return correosFavoritos;
    }
}
