package Listas_1;

public class Persona {    
    //atributos
    private String nombre;
    public String aPaterno;
    public String aMaterno;
    public int edad;

    //constructores
    public Persona(){}

    public Persona(String nombre, String aPaterno, String aMaterno, int edad){
        this.nombre=nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.edad=edad;
    }

    //para implementar equals
    public boolean equals(Object obj){
        Persona p = (Persona) obj;
        System.out.println("Comparando objetos " +p.nombre+ " contra " +this.nombre);
        if(p.nombre.equals(this.nombre) && p.aPaterno.equals(this.aPaterno) && p.aMaterno.equals(this.aMaterno) && p.edad==this.edad){
        //if(p.edad == this.edad){ para buscar por edad
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        String estado = ("Nombre: " +nombre+ " Apellidos: " +aPaterno+ " " +aMaterno+ " Edad: " +edad+ "\n");
        return estado;
    }
}
