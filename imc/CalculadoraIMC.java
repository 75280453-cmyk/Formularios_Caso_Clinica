package clinica.imc;
//DIP
// Depende de ClasificacionIMCPolicy, no de una clasificación concreta
public class CalculadoraIMC {

    public ResultadoIMC calcular(Paciente paciente, ClasificacionIMCPolicy politica) {
        double talla      = paciente.getTalla();
        double peso       = paciente.getPeso();
        double imc        = peso / (talla * talla);
        double pesoIdeal  = talla * talla * 22.5;
        double diferencia = peso - pesoIdeal;
        String clasif     = politica.clasificar(imc);

        return new ResultadoIMC(
            paciente.getNombre(),
            imc, clasif,
            pesoIdeal, diferencia
        );
    }
}