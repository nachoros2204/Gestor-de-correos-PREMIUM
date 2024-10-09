package main.Filtros;

import java.util.ArrayList;

import main.Mail;

public class FiltroDeTituloYMensaje extends Filtro {
    public FiltroDeTituloYMensaje(){
        super.setNombre("Filtro de Asunto y Mensaje");
    }
    

    @Override
     public ArrayList<Mail> filtrar(String buscarTitulo, String buscarOtro, ArrayList<Mail> correos){
          FiltroDeTitulo filtroTitulo = new FiltroDeTitulo();
          FiltroDeMensaje filtroMensaje = new FiltroDeMensaje();
          
          ArrayList<Mail> resultadosTitulo = filtroTitulo.filtrar(buscarTitulo, correos);
          ArrayList<Mail> resultadosMensaje = filtroMensaje.filtrar(buscarOtro, correos);

          ArrayList<Mail> resultado = new ArrayList<>(resultadosTitulo);
          resultado.retainAll(resultadosMensaje);

          return resultado;
     }
}
