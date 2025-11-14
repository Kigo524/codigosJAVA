import java.util.Scanner;

public class PruebaPersona {
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        Persona1 memo = new Persona1();

        System.out.print(memo);//para comprobar

        System.out.println("Introduzca su nombre: ");
        String nombre= entrada.nextLine();

        System.out.println("\n Introduzca su edad: ");
        int edad = entrada.nextInt();

        // Comprobación de mayoría de edad
        if (memo.esMayorDeEdad()) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }
        
        System.out.println("\n Introduzca su peso: ");
        double peso = entrada.nextDouble();

        System.out.println("\n Introduzca su altura: ");
        double altura = entrada.nextDouble();

        System.out.println("\n Tus datos son: \n Nombre:" +nombre+ "\n Edad: " +edad+ "\n Peso: " +peso+ "\nAltura: " +altura);

        memo.setNombre(nombre); //memo.nombre=nombre
        memo.setEdad(edad);
        memo.setPeso(peso);
        memo.setAltura(altura);

        System.out.print(memo);

        //agregar su indice de masa corporal y y el sexo
    }
}
