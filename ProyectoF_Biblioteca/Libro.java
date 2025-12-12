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

    public String toString(){
        return "Datos de libro: " +titulo+ " | Id: " +id+ " | Autor: " +autor+ " | Año Publicado: " +anioPublicacion+ " | Editorial: " +editorial+ " | Páginas: " +numPaginas+ " | Edición: " +numEdicion;
    }
}
