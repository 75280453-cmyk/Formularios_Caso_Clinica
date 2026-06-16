package clinica.imc;

//SRP
public class ResultadoIMC {
    private String nombrePaciente;
    private double imc;
    private String clasificacion;
    private double pesoIdeal;
    private double diferencia;

    public ResultadoIMC(String nombrePaciente, double imc, String clasificacion,
                        double pesoIdeal, double diferencia) {
        this.nombrePaciente = nombrePaciente;
        this.imc            = imc;
        this.clasificacion  = clasificacion;
        this.pesoIdeal      = pesoIdeal;
        this.diferencia     = diferencia;
    }

    public String getNombrePaciente() { return nombrePaciente; }
    public double getImc()            { return imc; }
    public String getClasificacion()  { return clasificacion; }
    public double getPesoIdeal()      { return pesoIdeal; }
    public double getDiferencia()     { return diferencia; }
}