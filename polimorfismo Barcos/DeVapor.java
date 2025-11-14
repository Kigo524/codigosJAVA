package polimorfismo;

public class DeVapor extends Barco{
    public DeVapor(){
        System.out.println("Se crea la parte de un barco de vapor");
    }

    public void alarma(){
        System.out.println("\n S-O-S desde un Barco de Vapor...");
    }

    public void metodoDeVapor(){
        System.out.println("Ejecutando un metodo desde la clase DeVapor...");
    }
}
