package clinica.liquidacion;

public class ImpresoraLiquidacion implements ImpresionLiquidacion {
    @Override
    public void imprimir(DetalleLiquidacion d) {
        System.out.println("========================================");
        System.out.println("Médico          : " + d.getNombreMedico());
        System.out.println("Política        : " + d.getPoliticaNombre());
        System.out.println("Total consultas : S/ " + d.getTotalConsultas());
        System.out.println("Total labs      : S/ " + d.getTotalLabs());
        System.out.println("Total tele      : S/ " + d.getTotalTele());
        System.out.println("Total recaudado : S/ " + d.getTotalRecaudado());
        System.out.println("Comisión médico : S/ " + d.getComision());
        System.out.println("INGRESO NETO    : S/ " + d.getIngresoNeto());
        System.out.println("========================================");
    }
}