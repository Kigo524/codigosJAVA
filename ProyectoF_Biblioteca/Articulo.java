package ProyectoF_Biblioteca;

public class Articulo extends MaterialBibliografico{
    //atributos
    private String nombrePublicacionContenedora;
    private String rangoPaginas;

    //contrsuctor
    public Articulo(String id, String titulo, String autor, int anioPublicacion, String nombrePublicacionContenedora, String rangoPaginas){
        super(id, titulo, autor, anioPublicacion);
        this.nombrePublicacionContenedora=nombrePublicacionContenedora; //en que momento le di un nombre tan largo??
        this.rangoPaginas=rangoPaginas;
    }

    //getters y seters
    public String getNomPubliCont(){return nombrePublicacionContenedora;}
    public void setNomPubliCont(String nombrePublicacionContenedora){this.nombrePublicacionContenedora=nombrePublicacionContenedora;}

    public String getRangoPaginas(){return rangoPaginas;}

    //ahora el polimorfismo
    @Override
    public String obtenerInformacion(){
        String info= "Datos del Articulo: " +titulo+ "*****************************\n";
        info+= "Id: " +id+ " || Autor: " +autor+ "\n";
        info+= "Año publicación: " +anioPublicacion+ "\n";
        info+= "Ubicado en la publicación: " +nombrePublicacionContenedora+ "\n";
        info+= "Rango de páginas: " +rangoPaginas+ "\n";
        info+= "Disponible: " +(disponible ? "Si" : "No")+ "\n";
        return info;
    }

    public String toString(){
        return obtenerInformacion();
    }
}
