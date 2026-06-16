package clinica.cobro;

public class ImpresoraConsola implements ImpresionReporte {
    @Override
    public void imprimir(DetalleCobro d) {
        System.out.println("========================================");
        System.out.println("Paciente    : " + d.getNombrePaciente());
        System.out.println("Atención    : " + d.getTipoAtencion());
        System.out.println("Cobertura   : " + d.getPoliticaNombre());
        System.out.println("Costo base  : S/ " + d.getCostoBase());
        System.out.println("IGV (18%)   : S/ " + d.getIgv());
        System.out.println("Copago      : S/ " + d.getCopago());
        System.out.println("TOTAL       : S/ " + d.getTotalFinal());
        System.out.println("========================================");
    }
}
