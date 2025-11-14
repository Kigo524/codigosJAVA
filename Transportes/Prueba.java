package Transportes;

import java.util.Scanner;

public class Prueba {
    public static void main (String [] args){
        Automovil auto = new Automovil();
        Moto moto = new Moto();

        System.out.println(auto);
        System.out.println(moto);

        /*auto.acelerar(50);
        auto.acelerar(150);
        System.out.println(auto.frenar(100));

        System.out.println(auto);

        moto.acelerar(65);
        moto.acelerar(173);
        System.out.println(moto.frenar(100)); */

        //usando el metodo de abajo
        tiempoRecorrido(120, auto);
        tiempoRecorrido(70, moto);
    }

    public static void tiempoRecorrido(int velocidad, Transporte t){
        double distancia;
        double minutos;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Distancia en km que va a recorrer el transporte: "); //Aqui tengo un problema para como voy a imprimir que tipo de transporte es
        distancia = entrada.nextDouble();
        t.acelerar(velocidad);
        minutos = (double) (distancia / velocidad) * 60; //* es por 60 para hora */

        System.out.println("El transporte recorrera los " +distancia+ "km a una velocidad de " +velocidad+ "km/h en " +minutos+ " minutos");
    }
}
