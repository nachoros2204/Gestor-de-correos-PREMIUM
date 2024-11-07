package main;

import java.util.ArrayList;

public class Mail {
    private String titulo;
    private String mensaje;
    private String remitente;
    private ArrayList<String> destinatario = new ArrayList<>();
    private boolean esFavorito;

    public Mail(String titulo, String mensaje, String remitente, ArrayList<String> destinatario){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.esFavorito = false;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getMensaje(){
        return mensaje;
    }
    public String getRemitente(){
        return remitente;
    }
    public ArrayList<String> getDestinatario(){
        return destinatario;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }
    public void setEsFavorito(boolean esFavorito) {
        this.esFavorito = esFavorito;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo; 
    }
    public void setDestinatario(ArrayList<String> destinatario) {
        this.destinatario = destinatario;
    }

    public Mail clonar() {
        return new Mail(this.titulo, this.mensaje, this.remitente, new ArrayList<>(this.destinatario));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
        result = prime * result + ((remitente == null) ? 0 : remitente.hashCode());
        result = prime * result + ((destinatario == null) ? 0 : destinatario.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mail other = (Mail) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        if (remitente == null) {
            if (other.remitente != null)
                return false;
        } else if (!remitente.equals(other.remitente))
            return false;
        if (destinatario == null) {
            if (other.destinatario != null)
                return false;
        } else if (!destinatario.equals(other.destinatario))
            return false;
        return true;
    }

    // getter para saber si el correo es favorito
    public boolean esFavorito() {
        return esFavorito;
    }

    // metodo para marcar o desmarcar el correo como favorito
    public void marcarComoFavorito() {
        esFavorito = !esFavorito;
    }
    public boolean isEsFavorito() {
        return esFavorito;
    }
}
