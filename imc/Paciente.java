package clinica.imc;

//SRP
public class Paciente {
    private String nombre;
    private int edad;
    private String sexo;
    private double peso;
    private double talla;

    public Paciente(String nombre, int edad, String sexo, double peso, double talla) {
        this.nombre = nombre;
        this.edad   = edad;
        this.sexo   = sexo;
        this.peso   = peso;
        this.talla  = talla;
    }

    public String getNombre() { return nombre; }
    public int    getEdad()   { return edad; }
    public String getSexo()   { return sexo; }
    public double getPeso()   { return peso; }
    public double getTalla()  { return talla; }
}
