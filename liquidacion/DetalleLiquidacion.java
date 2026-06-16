package clinica.liquidacion;
//SRP
public class DetalleLiquidacion {
    private String nombreMedico, politicaNombre;
    private double totalConsultas, totalLabs, totalTele;
    private double totalRecaudado, comision, ingresoNeto;

    public DetalleLiquidacion(String nombreMedico, String politicaNombre,
                              double totalConsultas, double totalLabs, double totalTele,
                              double totalRecaudado, double comision, double ingresoNeto) {
        this.nombreMedico   = nombreMedico;
        this.politicaNombre = politicaNombre;
        this.totalConsultas = totalConsultas;
        this.totalLabs      = totalLabs;
        this.totalTele      = totalTele;
        this.totalRecaudado = totalRecaudado;
        this.comision       = comision;
        this.ingresoNeto    = ingresoNeto;
    }

    public String getNombreMedico()   { return nombreMedico; }
    public String getPoliticaNombre() { return politicaNombre; }
    public double getTotalConsultas() { return totalConsultas; }
    public double getTotalLabs()      { return totalLabs; }
    public double getTotalTele()      { return totalTele; }
    public double getTotalRecaudado() { return totalRecaudado; }
    public double getComision()       { return comision; }
    public double getIngresoNeto()    { return ingresoNeto; }
}
