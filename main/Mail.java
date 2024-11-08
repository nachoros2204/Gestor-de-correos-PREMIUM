package main;

import java.util.ArrayList;

public class Mail {
    private String titulo;
    private final String mensaje;
    private final String remitente;
    private ArrayList<String> destinatario = new ArrayList<>();
    private boolean esFavorito;

    public Mail(String titulo, String mensaje, String remitente, ArrayList<String> destinatario) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.esFavorito = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public ArrayList<String> getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(ArrayList<String> destinatario) {
        this.destinatario = destinatario;
    }

    public Mail clonar() {
        return new Mail(this.titulo, this.mensaje, this.remitente, new ArrayList<>(this.destinatario));
    }

    // Getter para saber si el correo es favorito
    public boolean esFavorito() {
        return esFavorito;
    }

    // Método para marcar o desmarcar el correo como favorito
    public void marcarComoFavorito() {
        esFavorito = !esFavorito;
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mail other = (Mail) obj;
        return titulo.equals(other.titulo) &&
               mensaje.equals(other.mensaje) &&
               remitente.equals(other.remitente) &&
               destinatario.equals(other.destinatario);
    }
}
