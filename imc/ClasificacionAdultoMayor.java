package clinica.imc;
//OCP
// Adultos mayores tienen rangos distintos de IMC saludable
public class ClasificacionAdultoMayor implements ClasificacionIMCPolicy {
    @Override
    public String clasificar(double imc) {
        if      (imc < 22.0) return "Bajo peso (adulto mayor)";
        else if (imc < 27.0) return "Normal (adulto mayor)";
        else if (imc < 32.0) return "Sobrepeso (adulto mayor)";
        else                 return "Obesidad (adulto mayor)";
    }
}
