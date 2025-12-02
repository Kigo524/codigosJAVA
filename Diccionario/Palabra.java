package Diccionario;

//tengo que hacerla comparable para poder usar treeset
public class Palabra implements Comparable<Palabra> {
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

    //tambien tengo que agregar un compareTo para que agregue alfabeticamente
    //esto lo hace comparando palabra nueva con la otra palabra
    public int compareTo(Palabra otraPalabra){
        return this.palabra.compareTo(otraPalabra.getPalabra()); //aqui compara la palabra existente con la palabra nueva
    }
}
