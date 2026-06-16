package clinica.liquidacion;
public class CalculadoraLiquidacion {
    private static final double TARIFA_CONSULTA = 150.0;
    private static final double TARIFA_LAB      = 120.0;
    private static final double TARIFA_TELE     =  60.0;

    public DetalleLiquidacion calcular(TurnoMedico turno, ComisionPolicy politica) {
        double totalConsultas = turno.getNumConsultas()     * TARIFA_CONSULTA;
        double totalLabs      = turno.getNumLaboratorios()  * TARIFA_LAB;
        double totalTele      = turno.getNumTelemedicinas() * TARIFA_TELE;
        double totalRecaudado = totalConsultas + totalLabs + totalTele;
        double comision       = politica.calcularComision(totalRecaudado);
        double ingresoNeto    = totalRecaudado - comision;

        return new DetalleLiquidacion(
            turno.getNombreMedico(),
            politica.nombre(),
            totalConsultas, totalLabs, totalTele,
            totalRecaudado, comision, ingresoNeto
        );
    }
}
