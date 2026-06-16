package clinica.cobro;
//DIP
public class CalculadoraCobro {
    private static final double IGV = 0.18;

    public DetalleCobro calcular(ServicioClinico servicio, CoberturaPolicy politica) {
        double costoBase = servicio.getCostoBase();
        double igv       = costoBase * IGV;
        double copago    = politica.calcularCopago(costoBase);
        double total     = copago + igv;

        return new DetalleCobro(
            servicio.getIdPaciente(),
            servicio.getNombrePaciente(),
            servicio.getTipoAtencion(),
            costoBase, igv, copago,
            politica.nombre(), total
        );
    }
}