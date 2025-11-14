package Ejercicio_2_Preexamen;

public class Pelicula extends Producto{
    //atributos
    public String anioEstreno;
    public String duracion;

    //constructores
    public Pelicula(){}

    
    public Pelicula(String id, String titulo, String genero, String anioEstreno, String duracion){
        super(id, titulo, genero);
        this.anioEstreno = anioEstreno;
        this.duracion= duracion;
    }

    //metodo
    public String toString(){
        return super.toString()+" Anio estreno: " +anioEstreno+ " DURACION: "+duracion;
    }
}
