package ProyectoF_Biblioteca;

public class Revista extends MaterialBibliografico{
    //atributos
    private String nombreRevista; //como Muy Interesante o Sabias que...?
    private int numVolumen;
    private int numEdicion;

    //constructr
    public Revista(String id, String titulo, String autor, int anioPublicacion, boolean disponible, String nombreRevista, int numVolumen, int numEdicion){
        super(id, titulo, autor, anioPublicacion, disponible); //ahora tambien recibe disponible del main
        this.nombreRevista=nombreRevista;
        this.numVolumen=numVolumen;
        this.numEdicion=numEdicion;
    }

    //getters y setters
    public String getNombreRevista(){return nombreRevista;}
    public void setNombreRevista(String nombreRevista){this.nombreRevista=nombreRevista;}

    public int getNumVolumen(){return numVolumen;}

    public int getNumEdicion(){return numEdicion;}

    //para eñ polimorfismo entiendo se escribe @override para el compilador sepa que es polimorfismo
    @Override
    public String obtenerInformacion(){
        String info = "REVISTA: " + titulo + " (ID: " + id + ")\n";
        info += "   Autor: " + autor + " | Año: " + anioPublicacion + "\n";
        info += "   Revista: " + nombreRevista + " | Volumen: " + numVolumen + " | Edición: " + numEdicion + "\n";
        info += "   Disponible: " + (disponible ? "SÍ" : "NO") + "\n";
        return info;
    }

    public String toString(){
        return obtenerInformacion();
    }
}
