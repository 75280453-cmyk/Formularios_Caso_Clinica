package clinica.cobro;
//SRP
public class DetalleCobro {
    private String idPaciente, nombrePaciente, tipoAtencion, politicaNombre;
    private double costoBase, igv, copago, totalFinal;

    public DetalleCobro(String idPaciente, String nombrePaciente, String tipoAtencion,
                        double costoBase, double igv, double copago,
                        String politicaNombre, double totalFinal) {
        this.idPaciente     = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.tipoAtencion   = tipoAtencion;
        this.costoBase      = costoBase;
        this.igv            = igv;
        this.copago         = copago;
        this.politicaNombre = politicaNombre;
        this.totalFinal     = totalFinal;
    }

    public String getIdPaciente()     { return idPaciente; }
    public String getNombrePaciente() { return nombrePaciente; }
    public String getTipoAtencion()   { return tipoAtencion; }
    public String getPoliticaNombre() { return politicaNombre; }
    public double getCostoBase()      { return costoBase; }
    public double getIgv()            { return igv; }
    public double getCopago()         { return copago; }
    public double getTotalFinal()     { return totalFinal; }
}