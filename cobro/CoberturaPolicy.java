package clinica.cobro;

// OCP DIP
public interface CoberturaPolicy {
    double calcularCopago(double costoBase);
    String nombre();
}
