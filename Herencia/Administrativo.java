package Herencia;

public class Administrativo extends Persona2 {
    //atributos
    public String numEmpleado;
    public int anioContratacion;

    //constructores
    public Administrativo(){}

    public Administrativo(String nombre, String apellidoP, String apellidoM, int edad, int diaNac, int mesNac, int anioNac, String numEmpleado, int anioContratacion){
        super(nombre, apellidoP, apellidoM, edad, diaNac, mesNac, anioNac);
        System.out.println("Contruyendo la parte Administrativo...");
        this.numEmpleado = numEmpleado;
        this.anioContratacion = anioContratacion;
    }

    //metodos
    public void cerrarPresupuesto(){
        System.out.println("Presupuesto cerrado por el administrativo " + this.numEmpleado);
    }

    public double calcularValeDespensa(double salario){
        double vale = salario * 0.04; // ejemplo: 4% del salario
        System.out.println("Vale de despensa calculado: " + vale);
        return vale;
    }
}