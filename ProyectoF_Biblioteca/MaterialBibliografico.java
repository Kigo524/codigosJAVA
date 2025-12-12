package ProyectoF_Biblioteca;

public abstract class MaterialBibliografico {
    //usare protected para que las clases hijas puedan acceder sin getter y ahorrame ese metodo
    protected String id;
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;
    protected boolean disponible;

    //constructor para atributos
    public MaterialBibliografico(String id, String titulo, String autor, int anioPublicacion){
        this.id=id;
        this.titulo=titulo;
        this.autor=autor;
        this.anioPublicacion=anioPublicacion;
        this.disponible=true;
    }

    //getter disponible
    public boolean isDisponible(){
        return this.disponible;
    }

    //setter disponible
    public void setDisponible(boolean disponible){
        this.disponible=disponible; //para que cambie entre true o false segun lo que escriba
    }
}
