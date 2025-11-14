package Ejercicio_Preexamen;

public class Persona {
    public String nombre;
    public String apellMaterno;
    public String apellPaterno;

    //constructor
    public Persona(String nombre, String apellPaterno, String apellMaterno){
        this.nombre= nombre;
        this.apellPaterno= apellPaterno;
        this.apellMaterno= apellMaterno;
    }

    //metodo
    public String toString(){
        String estado = "nombre: "+nombre+
                        ", Apellidos: "+apellPaterno+ " " +apellMaterno;
        return estado;
    }
}
