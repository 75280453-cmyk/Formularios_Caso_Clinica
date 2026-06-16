package clinica.liquidacion;
//SRP
public class TurnoMedico {
    private String nombreMedico;
    private int numConsultas;
    private int numLaboratorios;
    private int numTelemedicinas;

    public TurnoMedico(String nombreMedico, int numConsultas,
                       int numLaboratorios, int numTelemedicinas) {
        this.nombreMedico     = nombreMedico;
        this.numConsultas     = numConsultas;
        this.numLaboratorios  = numLaboratorios;
        this.numTelemedicinas = numTelemedicinas;
    }

    public String getNombreMedico()     { return nombreMedico; }
    public int    getNumConsultas()     { return numConsultas; }
    public int    getNumLaboratorios()  { return numLaboratorios; }
    public int    getNumTelemedicinas() { return numTelemedicinas; }
}
