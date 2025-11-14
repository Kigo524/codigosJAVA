package Herencia;

public class Persona2 {
    public static final int ANIO_ACT = 2025;

    //atributos
    private String nombre;
    public String apellidoP;
    public String apellidoM;
    public int edad;
    public int diaNac;
    public int mesNac;
    public int anioNac;

    //constructores
    public Persona2(){}

    public Persona2(String nombre, String apellidoP, String apellidoM, int edad, int diaNac, int mesNac, int anioNac){
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.edad=edad;
        this.diaNac=diaNac;
        this.mesNac=mesNac;
        this.anioNac=anioNac;
    }

    //metodos
    public void calculaEdad(){
        edad=ANIO_ACT-anioNac;
    }

    public String toString(){
        String estado= "nombre: " + nombre +
                        "\n Apellido Paterno: " +apellidoP+
                        "\n Apellido Materno: " +apellidoM+
                        "\n Edad: " +edad+
                        "\n Fecha de Nacimiento: " +diaNac + "/" + mesNac + "/" + anioNac;
        return estado;
    }
}
