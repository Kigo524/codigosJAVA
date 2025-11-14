import java.util.Scanner;

public class EntradaSalida{
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca su edad: ");
        int edad = entrada.nextInt();


        System.out.print("\n introduzca su promedio: ");
        double promedio = entrada.nextDouble();

        //limpiar buffer
        entrada.nextLine();

        System.out.println("\n Introduzca su nombre: ");
        String nombre = entrada.nextLine();

        System.out.println("\n Tu nombre es: " + nombre + "Tu edad es: " + edad + "Tu promedio es: " +promedio);
    }
}