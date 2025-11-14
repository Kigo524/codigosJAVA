package Autobus;

public class Asiento {
    
    //atributos
    private String id;
    private String numAsientos;

    //constructores
    public Asiento(){}

    public Asiento(String id, String numAsientos){
        System.out.println("Creando asientos...");
        this.id = id;
        this.numAsientos= numAsientos;
    }
}
