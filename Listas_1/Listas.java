package Listas_1;

import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Listas {
    public static void main (String [] args){
        ArrayList<String> lista = new ArrayList<>();

        System.out.println("Agregando objetos a la lista...");

        lista.add("Betzabet");
        lista.add("Guillermo");
        lista.add("Carlos");
        lista.add("Michelle");
        lista.add("Alam");
        lista.add("Enrique");
        lista.add("Isaac");

        System.out.println(lista.toString());

        //eliminando a alguien
        System.out.println("Eliminando a ALAM");
        System.out.println(lista.remove("Alam")); //necesita metodo equals
        System.out.println(lista.toString());

        //agregando al inicio. el 0 es la posicion
        System.out.println("Agregando elemento al incio...");
        lista.add(0, "Roberto");
        System.out.println(lista.toString()); //booleano

        //agregando a alguien en medio
        System.out.println("Agregando elemento al medio...");
        lista.add(5, "Sofia");
        System.out.println(lista.toString());

        //size es entero y es el numero de datos de la lista
        System.out.println("Numero de elementos en la lista: ");
        System.out.println(lista.size()); //entero

        //metodo GET, devuelve un objeto, entonces es mas sencillo imprimirlo
        System.out.println("Oobteniendo un objeto del indice 5...");
        System.out.println(lista.get(5)); //devuelve el objeto

        //SET sobreescribe lo que este en el indice en donde lo ponemos
        System.out.println("Colocar el objeto Francisco en el indice 2...");
        lista.set(2, "Francisco"); //devuelve el objeto a sobreescribir
        System.out.println(lista.toString());

        //metodo CONTAINS devuelve verdadero o falso si en la lista existe lo que estoy buscando
        System.out.println("Existe Carlo en la lista?...");
        System.out.println(lista.contains("Carlos")); //necesita metodo equals

        //INDEXOF nos devuelve el indice en donde esta el objeto
        System.out.println("Obtener el indice del elemento Enrique...");
        System.out.println(lista.indexOf("Enrique")); //tambien es entero y necesita equals

        //IS EMPTY para saber que esta vacia
        System.out.println("La lista esta vacia???");
        System.out.println(lista.isEmpty()); //devuelve un booleano

        //lista.clear --- para limpiar la lista
        lista.clear();

        System.out.println(lista.toString());
        System.out.println("La lista esta vacia??");
        System.out.println(lista.isEmpty());
    }
}
