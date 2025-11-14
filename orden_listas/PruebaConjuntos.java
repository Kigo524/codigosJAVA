package orden_listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

//no los ordena CORREGIR

public class PruebaConjuntos {
    public static void main (String [] args){
        Set<Persona> conjunto = new TreeSet<>();

        Persona p1 = new Persona("Betzabet", "Garcia", "Mendoza", 36);
        Persona p2 = new Persona("Alam", "Ortiz", "Baltazar", 21);
        Persona p3 = new Persona("Michelle", "Moran", "Cruz", 19);
        Persona p4 = new Persona("Sergio", "De Luis", "Sanchez", 24);
        Persona p5 = new Persona("Zury", "Bautista", "Baez", 15);
        Persona p6 = new Persona("Carlos", "Tornez", "Mendoza", 30);
        Persona p7 = new Persona("Alam", "Ortiz", "Baltazar", 21);

        conjunto.add(p1);
        conjunto.add(p2);
        conjunto.add(p3);
        conjunto.add(p4);
        conjunto.add(p1);
        conjunto.add(p5);
        conjunto.add(p6);
        conjunto.add(p3);
        conjunto.add(p7);

        System.out.println("Elementos de la lista: \n");
        System.out.println(conjunto);

        System.out.println("Elementos de la lista ORDENADOS: \n");
        System.out.println(conjunto);
    }
}

