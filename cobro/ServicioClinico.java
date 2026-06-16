package clinica.cobro;
//SRP
public class ServicioClinico {
    private String idPaciente;
    private String nombrePaciente;
    private String tipoAtencion;
    private double costoBase;

    public ServicioClinico(String idPaciente, String nombrePaciente,
                           String tipoAtencion, double costoBase) {
        this.idPaciente     = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.tipoAtencion   = tipoAtencion;
        this.costoBase      = costoBase;
    }

    public String getIdPaciente()     { return idPaciente; }
    public String getNombrePaciente() { return nombrePaciente; }
    public String getTipoAtencion()   { return tipoAtencion; }
    public double getCostoBase()      { return costoBase; }
}