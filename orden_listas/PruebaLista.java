package orden_listas;

import java.util.ArrayList;
import java.util.Collections;

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

        System.out.println("Elementos de la lista: \n");
        System.out.println(lista);

        Collections.sort(lista);

        System.out.println("Elementos de la lista ORDENADOS: \n");
        System.out.println(lista);
    }
}
