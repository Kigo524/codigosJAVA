package polimorfismo;

public class Carguero extends DeVapor{
    public Carguero(){
        System.out.println("Se crea la parte de un barco de Carguero");
    }  

    public void alarma(){
        System.out.println("\n S-O-S desde un Barco Carguero...");
    }

    public void metodoCarguero(){
        System.out.println("Ejecutando un metodo desde la clase Carguero...");
    }
}
