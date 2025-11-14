package Listas_1;

import java.util.ArrayList;

public class PruebaLista {
    public static void main (String [] args){
        ArrayList<Persona> lista = new ArrayList<>();

        Persona p1 = new Persona("Betzabet", "Garcia", "Mendoza", 36);
        Persona p2 = new Persona("Alam", "Ortiz", "Baltazar", 21);
        Persona p3 = new Persona("Michelle", "Moran", "Cruz", 19);
        Persona p4 = new Persona("Sergio", "De Luis", "Sanchez", 24);
        Persona p5 = new Persona("Zury", "Bautista", "Baez", 15);
        Persona p6 = new Persona("Carlos", "Tornez", "Mendoza", 30);

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);

        System.out.println(lista);

        System.out.println("El numero de elementos de la lista es: " +lista.size());

        Persona p7 = new Persona("Ana", "Cantillo", "Alva", 63);
        lista.add(3, p7);

        System.out.println(lista);

        Persona p8 = new Persona("Roberto", "Garcia", "Ramirez", 73);
        Persona p9 = null;
        p9 = lista.set(4, p8);
        System.out.println("Se sobre escribio el indice 4 y de borro a " +p9);

        System.out.println(lista);

        //devolver el de la posicion 5
        System.out.println(lista.get(5));

        Persona p10 = new Persona("Ana", "Cantillo", "Alva",63);
        System.out.println("Eliminando objeto Ana...");
        System.out.println(lista.remove(p10)); //si hubiera repetidos, solo elimina el primero


        System.out.println("Existe un Enrique en la lista? -> "lista.contains("Enrique"));
    }
}
