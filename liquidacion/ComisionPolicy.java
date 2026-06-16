package clinica.liquidacion;
// OCP DIP
public interface ComisionPolicy {
    double calcularComision(double totalRecaudado);
    String nombre();
}
