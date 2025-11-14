package Ejercicio_2_Preexamen;

public class Serie extends Producto{
    public String anioEstreno;
    public String numTemp;

    //construc
    public Serie (){}

    public Serie(String id, String titulo, String genero, String anioEstreno, String numTemp){
        super(id, titulo, genero);
        this.anioEstreno = anioEstreno;
        this.numTemp = numTemp;
    }

    //metodo
    public String toString(){
        return super.toString() + " ANIO DE ESTRENO: " +anioEstreno+ " TEMPORADAS: " + numTemp;
    } 
}
