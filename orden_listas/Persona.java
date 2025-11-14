package orden_listas;

public class Persona implements Comparable<Persona>{    
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

    //nosotros decidimos a apartir de que atributo vamos a validar si un objeto es mayor a otro
    /*public int compareTo(Persona p){
        if(this.edad < p.edad){
            return -1;
        } else if(this.edad > p.edad){
            return 1;
        } else {
            return 0;
        }
    }*/

    //Ordenando por nombre
    public int compareTo(Persona p){
        return this.nombre.compareTo(p.nombre);
    }

    public String toString(){
        String estado = ("Apellidos: " +aPaterno+ " " +aMaterno+ " Nombre: " +nombre+ " Edad: " +edad+ "\n");
        return estado;
    }
}
