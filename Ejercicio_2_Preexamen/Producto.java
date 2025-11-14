package Ejercicio_2_Preexamen;

public class Producto {
    public String id;
    public String titulo;
    public String genero;
    public boolean disponible; //para saber que esta disponible

    public Producto(){}

    //constructor
    public Producto(String id, String titulo, String genero){
        this.id = id;
        this.titulo= titulo;
        this.genero= genero;
        this.disponible = true; //porque esta disponible para rentarse jeje
    }

    //metodo getter/setter
    public boolean estaDisponible(){
        return disponible;
    }

    public void establecerDisponible(boolean disponible){
        this.disponible = disponible;
    }

    //metodo toString
    public String toString(){
        String estadoDisp = this.disponible ? "SI" : "NO";
        String estado = " ID: "+id+ " TITULO: "+titulo+ " GENERO: "+genero;
        return estado;
    }
}
