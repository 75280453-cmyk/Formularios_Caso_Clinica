package clinica.cobro;
//LSP
// Sustituye a ServicioClinico sin romper ningún comportamiento
public class ServicioTelemedicina extends ServicioClinico {
    public ServicioTelemedicina(String idPaciente, String nombrePaciente, double costoBase) {
        super(idPaciente, nombrePaciente, "Telemedicina", costoBase);
    }
}
