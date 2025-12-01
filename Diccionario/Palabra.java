package Diccionario;

public class Palabra {
    private String palabra;
    private String definicion;

    public Palabra(String palabra, String definicion) {
        this.palabra = palabra;
        this.definicion = definicion;
    }

    public String getPalabra() {
        return this.palabra;
    }

    public String getDefinicion() {
        return this.definicion;
    }

    public String toString() {
        return this.palabra + ": " + this.definicion;
    }
}
