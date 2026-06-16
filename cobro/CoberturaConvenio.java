package clinica.cobro;
//OCP
public class CoberturaConvenio implements CoberturaPolicy {
    @Override
    public double calcularCopago(double costoBase) {
        return costoBase * 0.20; // paciente paga 20%
    }

    @Override
    public String nombre() { return "Convenio Corporativo (copago 20%)"; }
}
