package Ejercicio_2_Preexamen;

public class Videojuego extends Producto{
    public String compania;
    public String maxJugadores;

    //constructores
    public Videojuego(){}

    public Videojuego(String id,String titulo, String genero, String compania, String maxJugadores){
        super(id, titulo, genero);
        this.compania= compania;
        this.maxJugadores= maxJugadores;
    }

    //metodo
    public String toString(){
        return super.toString()+" COMPANIA: "+ compania+ "MAXIMO DE JUGADORES: " + maxJugadores;
    }
}
