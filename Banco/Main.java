package Banco;

public class Main {
    public static void main(String[] args) {
        //creo el banco
        Banco miBanco = new Banco("Banco de KIGO");

        //ahora unas cuentas
        Cuenta cuenta1 = new Cuenta("1234", 5000.0);
        Cuenta cuenta2 = new Cuenta("5678", 1000.0);

        //Ahora usaurios
        Usuario user1 = new Usuario("Juan", "Perez", "Garcia", cuenta1);
        Usuario user2 = new Usuario("Maria", "Lopez", "Sosa", cuenta2);

        //aqui se registran a los usuarios en el banco
        System.out.println("\n ****** REGISTRANDO USAURIOS ******");
        miBanco.agregarUsuario(user1);
        miBanco.agregarUsuario(user2);

        //ahora la busqueda
        System.out.println("\n ****** PROBANDO BUSQUEDA ******");
        String numeroABuscar = "1234";
        Usuario cuentaEncontrada = miBanco.buscarCuenta(numeroABuscar);

        if(cuentaEncontrada != null){
            System.out.println("Cuenta encontrada!!!");
            cuentaEncontrada.imprimirDatos();
        

        //ahora las operaciones
        System.out.println("\n****** OPERACIONES ******");
        cuentaEncontrada.depositarEfectivo(2000); //saldo ahora es 7000
        cuentaEncontrada.retirarEfectivo(10000);//sale el mensaje de "Chambea"
        } else {
            System.out.println("La cuenta " +numeroABuscar+ " no existe.");
        }
    }
}
