package clinica.imc;
//OCP
public class ClasificacionAdulto implements ClasificacionIMCPolicy {
    @Override
    public String clasificar(double imc) {
        if      (imc < 18.5) return "Bajo peso";
        else if (imc < 25.0) return "Normal";
        else if (imc < 30.0) return "Sobrepeso";
        else                 return "Obesidad";
    }
}
