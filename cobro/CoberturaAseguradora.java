package clinica.cobro;

//OCP
public class CoberturaAseguradora implements CoberturaPolicy {
    @Override
    public double calcularCopago(double costoBase) {
        return costoBase * 0.30; // paciente paga 30%
    }

    @Override
    public String nombre() { return "Asegurado (copago 30%)"; }
}
