package Diccionario;

import java.util.ArrayList;

//aqui voy a manejar la lista de palabras

public class Letra {
    private char letra;
    private ArrayList<Palabra> palabras;

    public Letra(char letra) {
        this.letra = letra;
        this.palabras = new ArrayList<>();
    }

    //metodo
    public void agregarPalabra(Palabra p){
        palabras.add(p);
    }

    public void buscarPalabra(palabraABuscar){
        
        for(Palabra p : palabras){
            if(p.getPalabra().equals(palabraABuscar)){
                return p;
            }
        }

        System.out.println("ERROR, Palabra no encontrada...")
    }
}
