package Diccionario;

import java.util.TreeSet; //esto es para que se agregue en orden

//aqui voy a manejar la lista de palabras
//depende de Palabra

public class Letra {
    private char letra;
    private TreeSet<Palabra> palabras; //ocupo TreeSet en ligar de ArrayList

    public Letra(char letra) {
        this.letra = letra;
        this.palabras = new TreeSet<>();
    }

    //metodo
    public void agregarPalabra(Palabra p){
        palabras.add(p);
    }

    public Palabra buscarPalabra(String palabraABuscar){
        
        //compara la palabra ya existente con la palabra nueva
        for(Palabra p : palabras){
            if(p.getPalabra().equals(palabraABuscar)){
                return p;
            }
        }

        System.out.println("ERROR, Palabra: " +palabraABuscar+ " no encontrada...");
        return null;
    }

    public void imprimirPalabras(){
        for(Palabra p : palabras){
            System.out.println(" - " + p.toString());
        }
    }

    public boolean tienePalabras(){
        return !palabras.isEmpty(); //para que sea true si el arbol tiene algo dentro
    }
    //y el getter para la letra
    public char getLetra(){
        return letra;
    }
}
