public class FiltroDeRemitente extends Filtro {

    public FiltroDeRemitente() {
        super.setNombre("Filtro de Remitente");
    }

    @Override
protected ArrayList<Correo> buscarString(String buscar, Buzon buzon) {
    ArrayList<Correo> correos = buzon.getTodo().stream()
             .filter(correo -> correo.getRemitente().contains(buscar))
             .collect(Collectors.toCollection(ArrayList::new)); // Colecciona los correos filtrados en un ArrayList
     return correos; // Retorna el ArrayList con los correos filtrados
}