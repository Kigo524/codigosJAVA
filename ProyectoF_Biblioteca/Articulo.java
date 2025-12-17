package ProyectoF_Biblioteca;

public class Articulo extends MaterialBibliografico{
    //atributos
    private String nombrePublicacionContenedora;
    private String rangoPaginas;

    //contrsuctor
    public Articulo(String id, String titulo, String autor, int anioPublicacion, boolean disponible, String nombrePublicacionContenedora){
        super(id, titulo, autor, anioPublicacion, disponible);
        this.nombrePublicacionContenedora=nombrePublicacionContenedora; //en que momento le di un nombre tan largo??
        this.rangoPaginas="No definido";
    }

    //getters y seters
    public String getNombrePublicacionContenedora(){return nombrePublicacionContenedora;}
    public void setgetNombrePublicacionContenedora(String nombrePublicacionContenedora){
        this.nombrePublicacionContenedora=nombrePublicacionContenedora;
    }

    public String getRangoPaginas(){return rangoPaginas;}

    //ahora el polimorfismo
    @Override
    public String obtenerInformacion(){
        String info = "ARTÍCULO: " + titulo + " (ID: " + id + ")\n";
        info += "   Autor: " + autor + " | Año: " + anioPublicacion + "\n";
        info += "   Publicado en: " + nombrePublicacionContenedora + "\n";
        info += "   Disponible: " + (disponible ? "SÍ" : "NO") + "\n";
        return info;
    }

    //el toString lo saca desde MaterialBibliografico
}
