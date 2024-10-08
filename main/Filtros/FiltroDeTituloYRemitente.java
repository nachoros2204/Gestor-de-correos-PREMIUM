import java.util.ArrayList;

import Filtro.Filtro;
import GestorCorreo.*;

public class FiltroDeTituloYRemitente extends Filtro {
    public FiltroDeTituloYRemitente(){
        super.setNombre("Filtro de Asunto y Remitente");
    }

    @Override
    public ArrayList<Correo> filtrar(String buscarTitulo, String buscarOtro, Buzon buzon) {
        FiltroDeTitulo filtroTitulo = new FiltroDeTitulo();
        FiltroDeRemitente filtroRemitente = new FiltroDeRemitente();

        ArrayList<Correo> resultadosTitulo = filtroTitulo.filtrar(buscarTitulo, buzon);
        ArrayList<Correo> resultadosRemitente = filtroRemitente.filtrar(buscarOtro, buzon);

        ArrayList<Correo> resultado = new ArrayList<>(resultadosTitulo);
        resultado.retainAll(resultadosRemitente);

        return resultado;
    }
}
