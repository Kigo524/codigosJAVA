package Diccionario;

import java.util.ArrayList;

public class Letra {
    private char Letra;
    private ArrayList<Palabra> palabras;

    public Letra(char Letra) {
        this.Letra = Letra;
        this.palabras = new ArrayList<>();
    }

    //metodo
    public void agregarPalabra(Palabra p){
        palabras.add(p);
    }

    public void buscarPalabra
}
