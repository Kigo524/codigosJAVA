package ProyectoF_Biblioteca_2243030419;

public abstract class MaterialBibliografico {
    //usare protected para que las clases hijas puedan acceder sin getter y ahorrame ese metodo
    protected String id;
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;
    protected boolean disponible;

    //constructor para atributos
    public MaterialBibliografico(String id, String titulo, String autor, int anioPublicacion, boolean disponible){
        this.id=id;
        this.titulo=titulo;
        this.autor=autor;
        this.anioPublicacion=anioPublicacion;
        this.disponible=disponible; //corregí despues y ahora toma el valor que manda el main
    }

    //agrego los getters por lo del encapsulamiento
    public String getId(){return id;}
    public String getTitulo(){return titulo;}
    public String getAutor(){return autor;}
    public int getAnioPublicacion(){return anioPublicacion;}

    //getter de disponible
    public boolean isDisponible(){
        return this.disponible;
    }

    //setter de disponible
    public void setDisponible(boolean disponible){
        this.disponible=disponible; //para que cambie entre true o false segun lo que escriba
    }

    //agrego el metodo abstracto para usar en el polimorfismo
    //aqui solo se declara este metodo
    public abstract String obtenerInformacion();

    public String toString(){
        return obtenerInformacion();
    }
}
