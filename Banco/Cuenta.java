package Banco;

public class Cuenta {
    // atributos
    public String numCuenta;
    public double saldo;
    public static final int LIMITE = 20000;

    // constructores
    public Cuenta() {
    }

    public Cuenta(String numCuenta, double saldo) {
        System.out.println("Creando la cuenta... ");
        this.numCuenta=numCuenta;
        this.saldo=saldo;
    }

    // metodos
    public void depositarEfectivo(double monto) {
        if (saldo + monto <= LIMITE) {
            saldo = saldo + monto;
            System.out.println("Se han abonado " + monto + " a la cuenta. Saldo actual: " + saldo);
        } else if (saldo + monto > LIMITE) {
            System.out.println("ERROR, el monto supera el limite de saldo permitido ($" + LIMITE + ")");
        }
    }

    public void retirarEfectivo(double monto) {
        if (saldo >= monto) {
            saldo = saldo - monto;
            System.out.println("Se han retirado " + monto + "de la cuenta. Saldo actual: " + saldo);
        } else {
            System.out.println("No se puede hacer un retiro mayor al saldo disponible. Chambea");
        }
    }

    public void imprimirSaldo() {
        System.out.println("Saldo en la cuenta: $" + saldo);
    }

    public String getNumCuenta() {
        return numCuenta;
    }
}