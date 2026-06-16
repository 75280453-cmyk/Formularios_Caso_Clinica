package clinica.cobro;
//OCP
public class CoberturaParticular implements CoberturaPolicy {
    @Override
    public double calcularCopago(double costoBase) {
        return costoBase; // paga el 100%
    }

    @Override
    public String nombre() { return "Particular (100%)"; }
}
