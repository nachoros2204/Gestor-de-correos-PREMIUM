package main.filtros;

import java.util.ArrayList;
import main.Mail;

public class FiltroDeTituloYRemitente extends Filtro {
    public FiltroDeTituloYRemitente(){
        super.setNombre("Filtro de Asunto y Remitente");
    }

    @Override
    public ArrayList<Mail> filtrar(String buscarTitulo, String buscarOtro, ArrayList<Mail> correos) {
        FiltroDeTitulo filtroTitulo = new FiltroDeTitulo();
        FiltroDeRemitente filtroRemitente = new FiltroDeRemitente();

        ArrayList<Mail> resultadosTitulo = filtroTitulo.filtrar(buscarTitulo, correos);
        ArrayList<Mail> resultadosRemitente = filtroRemitente.filtrar(buscarOtro, correos);

        ArrayList<Mail> resultado = new ArrayList<>(resultadosTitulo);
        resultado.retainAll(resultadosRemitente);

        return resultado;
    }
}
