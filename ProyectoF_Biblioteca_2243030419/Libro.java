package ProyectoF_Biblioteca_2243030419;

public class Libro extends MaterialBibliografico{
    //atributos
    //private String editorial; ***las agrgego despues de que funcione
    private int numPaginas;
    //private int numEdicion;

    //constuctor
    public Libro(String id, String titulo, String autor, int anioPublicacion, boolean disponible, int numPaginas){
        super(id, titulo, autor, anioPublicacion, disponible);
        //this.editorial=editorial;
        this.numPaginas=numPaginas;
        //this.numEdicion=numEdicion;
    }

    //getters y setters
    //public String getEditorial(){return editorial;}
    //public void setEditorial(String editorial){this.editorial=editorial;}

    public int getNumPaginas(){return numPaginas;}
    public void setNumPaginas(int numPaginas){this.numPaginas = numPaginas;}

    //public int getNumEdicion(){return numEdicion;} //aqui lo mismo que ARRIBA

    //para usar el polimorfismo... agrego override para qeu sepa el compilador que va a sobreescribir
    @Override
    public String obtenerInformacion(){
        String info = "LIBRO: " + titulo + " (ID: " + id + ")\n";
        info += "   Autor: " + autor + " | Año: " + anioPublicacion + "\n";
        info += "   Páginas: " + numPaginas + "\n";
        info += "   Disponible: " + (disponible ? "SÍ" : "NO") + "\n";
        return info;
    }

    //el toString va en el MaterialBibliografico *** esto es despues de crear el main
}
