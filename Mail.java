import java.util.ArrayList;

public class Mail {
    private String titulo;
    private String mensaje;
    private String remitente;
    private ArrayList<String> destinatario = new ArrayList<>();
    
    public Mail(String titulo, String mensaje, String remitente, ArrayList<String> destinatario){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.destinatario = destinatario;
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
}
