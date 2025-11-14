package Banco;

public class Usuario {
    //atributos
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private Cuenta cuenta;

    //constructores
    private Usuario(){}

    public Usuario(String nombre, String aPaterno, String aMaterno){
        System.out.println("Creando usuario...");
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.cuenta = cuenta;
    }

    public void depositarEfectivo(double monto){
        this.cuenta.depositarEfectivo(monto);
    }

    public void retirarEfectivo(double monto){
        this.cuenta.retirarEfectivo(monto);
    }

    public void imprimirSaldo(){
        this.cuenta.imprimirSaldo();
    }

    public void imprimirDatos(){
        System.out.println("*** Datos del usuaio ***");
        System.out.println("Nombre: " +this.nombre+ " " +this.aPaterno+ " " +this.aMaterno);
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCueta(){
        return 
    }
}