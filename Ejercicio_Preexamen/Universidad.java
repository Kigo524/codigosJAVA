package Ejercicio_Preexamen;

public class Universidad {
    public static void main(String [] args){

        System.out.println("Prueba de clases...");

        //crear UEAS
        System.out.println("Creando UEAS... \n");

        UEA uea1 = new UEA("Programacion Orientada a Objetos", "POO", "103");
        UEA uea2 = new UEA("Bases de Datos", "BD-402", "205");
        UEA uea3 = new UEA("Estructura de Datos", "ED-203","102");
        UEA uea4 = new UEA("Calculo Integral", "CI-104", "301");
        UEA uea5 = new UEA("Redes de Computo", "RC-505", "401");
        UEA uea6 = new UEA("Inteligencia Artificial", "IA-606", "501");

        System.out.println("UEA Creada: " + uea1.toString());

        //crear alumnos
        System.out.println("\nCreando alumnos...\n");

        Alumno a1 = new Alumno("Luis", "Hernandez", "Perez", "123456", "Tecnologias");

        System.out.println("Alumno creado: " + a1.toString());

        //Agregar UEAS a alumno
        System.out.println("\nAgregando UEAS al alumno: " + a1.nombre+ " con matricula: " + a1.matricula);

        a1.agregarUEA(uea1); //poo
        a1.agregarUEA(uea6); //ia
        a1.agregarUEA(uea3); //ed
        a1.agregarUEA(uea4); //ci
        a1.agregarUEA(uea5); //redes

        System.out.println("\nIntentando agregar una sexta uea...");
        a1.agregarUEA(uea2); //bd

        //ver las ueas inscritas al alumnos
        a1.mostrarUEASInscritas();

        //crear un profesor
        System.out.println("\nCreando un profesor...");

        Profesor profe1 = new Profesor("Maria", "Perez", "Rojas", "098765", "Computo avanzado");

        System.out.println("Profesor creado: " + profe1.toString());

        //agregar UEAS al profe
        System.out.println("\nAgregando UEAS al profe " + profe1.toString());

        profe1.agregarUEA(uea1); //poo
        profe1.agregarUEA(uea2); //bd
        profe1.agregarUEA(uea3); //ed

        //intento agregar una 4a uea
        System.out.println("\nInentando agregar una cuarta UEA...");
        profe1.agregarUEA(uea5); //redes

        //ver las ueas del profe
        profe1.mostrarUEASInscritas();
    }
}
