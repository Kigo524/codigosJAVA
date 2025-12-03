package Diccionario;

public class Main {
    
    public static void main(String[] args) {
        
        //primero quiero que imprima el diccionario
        Diccionario diccionario = new Diccionario();
        diccionario.imprimirDiccionario(); //aqui sale vacio

        //creo ahora si las palabras
        Palabra abeja = new Palabra("abeja", "insecto productor de miel");
        System.out.println("Palabra agregada con exito...");

        Palabra orangutan = new Palabra("orangutan", "animal que canta jazz agogo");

        diccionario.imprimirDiccionario();
    }
}
