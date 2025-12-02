package Diccionario;

import java.util.ArrayList;

//esto va a tener la lista de las letras y palabras
public class Diccionario {
    //atributos
    private ArrayList<Letra> letras;

    //constructor
    public Diccionario(){
        this.letras = new ArrayList<>();
    }

    public void agregarPalabra(String palabra, String definicion){
        //toLowerCase es para dejar todo en minusculas
        String termino = palabra.toLowerCase(); //cambio a termino porqeu sino se duplica definicion
        if(termino.isEmpty()) return; //agrega una palabra pero crea una Letra si es necesario

        char inicial = termino.charAt(0); //si no existe esa palabra...
        Palabra nuevaPalabra = new Palabra(termino, definicion);

        
    }

    //aqui quiero que busque la letra para que la cree si es una palabra nueva con letra nueva
    private Letra buscarLetra(char inicial){
        for(Letra l : letras){
            if(l.getLetra() == inicial){
                return l;
            }
        }
        return null;
    }
}
