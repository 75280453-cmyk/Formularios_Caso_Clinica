package clinica.cobro;


public class Main {
    public static void main(String[] args) {

        CalculadoraCobro calculadora = new CalculadoraCobro();
        ImpresionReporte impresora   = new ImpresoraConsola();

        // Caso 1: Paciente particular con consulta general
        ServicioClinico consulta = new ServicioClinico(
            "P001", "Ana Torres", "Consulta General", 80.0
        );
        impresora.imprimir(calculadora.calcular(consulta, new CoberturaParticular()));

        // Caso 2: Paciente asegurado con laboratorio
        ServicioClinico laboratorio = new ServicioClinico(
            "P002", "Luis Pérez", "Laboratorio", 120.0
        );
        impresora.imprimir(calculadora.calcular(laboratorio, new CoberturaAseguradora()));

        // Caso 3: Paciente con convenio corporativo por telemedicina (LSP)
        ServicioClinico tele = new ServicioTelemedicina(
            "P003", "María Ríos", 60.0
        );
        impresora.imprimir(calculadora.calcular(tele, new CoberturaConvenio()));

        // Caso 4: Paciente asegurado con consulta de especialidad
        ServicioClinico especialidad = new ServicioClinico(
            "P004", "Carlos Vega", "Consulta Cardiología", 150.0
        );
        impresora.imprimir(calculadora.calcular(especialidad, new CoberturaAseguradora()));
    }
}
