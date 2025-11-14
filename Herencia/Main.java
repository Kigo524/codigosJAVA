package Herencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué tipo de empleado quieres ingresar?");
        System.out.println("1. Administrativo");
        System.out.println("2. Programador");
        System.out.print("Selecciona (1 o 2): ");
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido paterno: ");
        String apellidoP = sc.nextLine();
        System.out.print("Apellido materno: ");
        String apellidoM = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Dia de nacimiento: ");
        int diaNac = sc.nextInt();
        System.out.print("Mes de nacimiento: ");
        int mesNac = sc.nextInt();
        System.out.print("Año de nacimiento: ");
        int anioNac = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Número de empleado: ");
        String numEmpleado = sc.nextLine();
        System.out.print("Año de contratación: ");
        int anioContratacion = sc.nextInt();

        if (opcion == 1) {
            Administrativo admin = new Administrativo(nombre, apellidoP, apellidoM, edad, diaNac, mesNac, anioNac, numEmpleado, anioContratacion);
            admin.cerrarPresupuesto();
            System.out.print("Salario para calcular vale de despensa: ");
            double salario = sc.nextDouble();
            admin.calcularValeDespensa(salario);
            System.out.println(admin.toString());
        } else if (opcion == 2) {
            System.out.print("Proyectos actuales: ");
            int proyectosActuales = sc.nextInt();
            System.out.print("Proyectos finalizados: ");
            int proyectosFinalizados = sc.nextInt();
            Programador prog = new Programador(nombre, apellidoP, apellidoM, edad, diaNac, mesNac, anioNac, numEmpleado, anioContratacion, proyectosActuales, proyectosFinalizados);
            System.out.println("Número de empleado: " + prog.numEmpleado);
            double valeDespensa = prog.calcularValeDespensa();
            System.out.println("Vale de despensa: " + valeDespensa);
            System.out.println(prog.toString());
        } else {
            System.out.println("Opción no válida.");
        }
        sc.close();
    }
}