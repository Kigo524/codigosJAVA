package Herencia;

public class Programador extends Administrativo {
    //atributos
    public int proyectosActuales;
    public int proyectosFinalizados;

    //constructores
    public Programador(){}

    public Programador(String nombre, String apellidoP, String apellidoM, int edad, int diaNac, int mesNac, int anioNac, String numEmpleado, int anioContratacion, int proyectosActuales, int proyectosFinalizados){
        super(nombre, apellidoP, apellidoM, edad, diaNac, mesNac, anioNac, numEmpleado, anioContratacion);
        System.out.println("Contruyendo la parte Programador...");
        this.proyectosActuales = proyectosActuales;
        this.proyectosFinalizados = proyectosFinalizados;
    }

    //metodos propios
    public double calcularValeDespensa(){
        double importe, extra;
        extra = proyectosFinalizados * 100;
        importe= (ANIO_ACT - anioContratacion) * 350;
        importe = importe + extra;
        return importe;
    }

    public String toString() {
    String papa = super.toString();
    String estado = papa + "\nProyectos actuales: " + proyectosActuales + 
                            "\nProyectos finalizados: " + proyectosFinalizados;
    return estado;
    }
}
