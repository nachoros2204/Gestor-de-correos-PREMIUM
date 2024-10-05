import java.util.ArrayList;

import Filtro.Filtro;

public class FiltroDeTituloYMensaje extends Filtro {
    public FiltroDeTituloYMensaje(){
        super.setNombre("Filtro de Asunto y Mensaje");
    }
    

    @Override
     public ArrayList<Correo> filtrar(String buscarTitulo, String buscarOtro, Buzon buzon){
          FiltroDeTitulo filtroTitulo = new FiltroDeTitulo();
          FiltroDeMensaje filtroMensaje = new FiltroDeMensaje();
          
          ArrayList<Correo> resultadosTitulo = filtroTitulo.filtrar(buscarTitulo, buzon);
          ArrayList<Correo> resultadosMensaje = filtroMensaje.filtrar(buscarOtro, buzon);

          ArrayList<Correo> resultado = new ArrayList<>(resultadosTitulo);
          resultado.retainAll(resultadosMensaje);

          return resultado;
     }
}
