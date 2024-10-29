package main;

import java.util.ArrayList;

public class Mail {
    private String titulo;
    private final String mensaje;
    private final String remitente;
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
    public void setTitulo(String titulo){
        this.titulo = titulo; 
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
    public Mail clonar() {
        return new Mail(this.titulo, this.mensaje, this.remitente, this.destinatario);
    }

    // getter para saber si el correo es favorito
    public boolean esFavorito() {
        return esFavorito;
    }

    // metodo para marcar o desmarcar el correo como favorito
    public void marcarComoFavorito() {
        esFavorito = !esFavorito;
    }




}
