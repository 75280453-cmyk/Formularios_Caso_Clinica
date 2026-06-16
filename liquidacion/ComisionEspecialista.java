package clinica.liquidacion;

public class ComisionEspecialista implements ComisionPolicy {
    @Override
    public double calcularComision(double totalRecaudado) {
        return totalRecaudado * 0.35; // especialista recibe 35%
    }

    @Override
    public String nombre() { return "Comisión Especialista (35%)"; }
}
