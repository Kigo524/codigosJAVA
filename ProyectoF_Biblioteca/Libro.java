package ProyectoF_Biblioteca;

public class Libro extends MaterialBibliografico{
    //atributos
    private String editorial;
    private int numPaginas;
    private int numEdicion;

    //constuctor
    public Libro(String id, String titulo, String autor, int anioPublicacion, String editorial, int numPaginas, int numEdicion){
        super(id, titulo, autor, anioPublicacion);
        this.editorial=editorial;
        this.numPaginas=numPaginas;
        this.numEdicion=numEdicion;
    }

    //getters y setters
    public String getEditorial(){return editorial;}
    public void setEditorial(String editorial){this.editorial=editorial;}

    public int getNumPaginas(){return numPaginas;} //aqui creo que no necesito setters, sino AGREGO DESPUES

    public int getNumEdicion(){return numEdicion;} //aqui lo mismo que ARRIBA

    //para usar el polimorfismo... agrego override para qeu sepa el compilador que va a sobreescribir
    @Override
    public String obtenerInformacion(){
        String info= "Datos del libro: " +titulo+ "*****************************\n";
        info+= "Id: " +id+ " || Autor: " +autor+ "\n";
        info+= "Año publicación: " +anioPublicacion+ " || Editorial: " +editorial+ "\n";
        info+= "Páginas: " +numPaginas+ " || Edicion: " +numEdicion+ "\n";
        info+= "Disponible: " +(disponible ? "Si" : "No")+ "\n";
        return info;
    }

    //dejo el toString para hacerlo mas facil en la lista final
    public String toString(){
        return obtenerInformacion();
    }
}
