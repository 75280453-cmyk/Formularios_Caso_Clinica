package clinica.liquidacion;

public class Main {
    public static void main(String[] args) {

        CalculadoraLiquidacion calculadora = new CalculadoraLiquidacion();
        ImpresionLiquidacion   impresora   = new ImpresoraLiquidacion();

        // Caso 1: Médico general con comisión estándar
        TurnoMedico turno1 = new TurnoMedico(
            "Dr. Juan Ríos", 8, 3, 2
        );
        impresora.imprimir(calculadora.calcular(turno1, new ComisionEstandar()));

        // Caso 2: Médico especialista con comisión de especialista
        TurnoMedico turno2 = new TurnoMedico(
            "Dra. Sofía Lara", 5, 0, 4
        );
        impresora.imprimir(calculadora.calcular(turno2, new ComisionEspecialista()));

        // Caso 3: Médico de laboratorio con comisión estándar
        TurnoMedico turno3 = new TurnoMedico(
            "Dr. Pedro Salas", 0, 10, 0
        );
        impresora.imprimir(calculadora.calcular(turno3, new ComisionEstandar()));

        // Caso 4: Médico mixto con comisión especialista
        TurnoMedico turno4 = new TurnoMedico(
            "Dra. Rosa Mendez", 6, 4, 3
        );
        impresora.imprimir(calculadora.calcular(turno4, new ComisionEspecialista()));
    }
}
