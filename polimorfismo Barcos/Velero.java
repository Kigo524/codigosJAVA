package polimorfismo;

public class Velero extends Barco{
    public Velero(){
        System.out.println("Se crea la parte de un barco de Velero");
    }  

    public void alarma(){
        System.out.println("\n S-O-S desde un Barco Velero...");
    }

    public void metodoVelero(){
        System.out.println("Ejecutando un metodo desde la clase Velero...");
    }
}
