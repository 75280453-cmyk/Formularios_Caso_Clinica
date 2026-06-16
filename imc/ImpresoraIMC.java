package clinica.imc;
//DIP
public class ImpresoraIMC implements ImpresionIMC {
    @Override
    public void imprimir(ResultadoIMC r) {
        System.out.println("========================================");
        System.out.println("Paciente      : " + r.getNombrePaciente());
        System.out.println("IMC           : " + String.format("%.2f", r.getImc()));
        System.out.println("Clasificación : " + r.getClasificacion());
        System.out.println("Peso ideal    : " + String.format("%.2f", r.getPesoIdeal()) + " kg");
        System.out.println("Diferencia    : " + String.format("%.2f", r.getDiferencia()) + " kg");
        System.out.println("========================================");
    }
}
