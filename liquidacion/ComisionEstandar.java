
package clinica.liquidacion;
//OCP
public class ComisionEstandar implements ComisionPolicy {
    @Override
    public double calcularComision(double totalRecaudado) {
        return totalRecaudado * 0.20; // médico recibe 20%
    }

    @Override
    public String nombre() { return "Comisión Estándar (20%)"; }
}