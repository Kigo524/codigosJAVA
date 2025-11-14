package Ejercicio_Preexamen;

public class Alumno extends Persona{
    //atributos
    public String matricula;
    public String licenciatura;
    //arreglo de UEAS
    UEA [] ueas;
    int numUEAS;

    //constructores
    public Alumno(){
        super("","","");
        ueas = new UEA[5]; //solo poder inscribir 5 ueas
        this.numUEAS = 0;
    }

    public Alumno(String nombre, String apellPaterno, String apellMaterno, String matricula, String licenciatura){
        super(nombre, apellPaterno, apellMaterno);
        this.matricula = matricula;
        this.licenciatura = licenciatura;
        ueas = new UEA[5];
        
    }

    //metodos
    public String toString(){
        String papa = super.toString();
        String estado = papa + ", matricula: " + matricula+
                                ", licenciatura: "+licenciatura;
        return estado;
    }

    public void agregarUEA(UEA nuevaUEA){
        //verificar si hay espacio
        if(this.numUEAS < this.ueas.length){
            //guardar la nueva UEA en la posicion actual
            //numUEAS es la posicion del primer espacio
            this.ueas[this.numUEAS] = nuevaUEA;

            //Incrementar el contador para la proxima vez
            //Con esto, numEAS apuntara al siguiente espacio vacio
            this.numUEAS++;
        } else {
            System.out.println("ERROR, el alumno ya ha inscrito el maximo de UEAS posibles (5)");
        }
    }

    //para mostrar ueas
    public void mostrarUEASInscritas(){
        System.out.println("\n*** UEAs inscritas por: " + this.nombre + " ***");

        //si aun no tiene inscritas
        if(this.numUEAS == 0){
            System.out.println("El alumno no tiene UEAs inscritas");
            return;
        }

        //si tiene algunas inscritas
        for(int i=0; i<this.numUEAS; i++){
            System.out.println(this.ueas[i].toString());
        }
        System.out.println("\nTotal de UEAs: " + this.numUEAS);
    }
}
