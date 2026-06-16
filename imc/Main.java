package clinica.imc;


public class Main {
    public static void main(String[] args) {

        CalculadoraIMC calculadora = new CalculadoraIMC();
        ImpresionIMC   impresora   = new ImpresoraIMC();

        // Caso 1: Adulto con peso normal
        Paciente p1 = new Paciente("Ana Torres", 28, "Femenino", 60.0, 1.65);
        impresora.imprimir(calculadora.calcular(p1, new ClasificacionAdulto()));

        // Caso 2: Adulto con sobrepeso
        Paciente p2 = new Paciente("Luis Pérez", 35, "Masculino", 90.0, 1.70);
        impresora.imprimir(calculadora.calcular(p2, new ClasificacionAdulto()));

        // Caso 3: Adulto mayor con clasificación especial
        Paciente p3 = new Paciente("Carmen Ruiz", 68, "Femenino", 70.0, 1.58);
        impresora.imprimir(calculadora.calcular(p3, new ClasificacionAdultoMayor()));

        // Caso 4: Adulto con bajo peso
        Paciente p4 = new Paciente("Jorge Díaz", 22, "Masculino", 55.0, 1.80);
        impresora.imprimir(calculadora.calcular(p4, new ClasificacionAdulto()));
    }
}
