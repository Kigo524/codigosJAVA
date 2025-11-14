package Ejercicio_Preexamen;

public class Profesor extends Persona{
    //atributos
    public String numEconomico;
    public String departamento;
    UEA [] ueas;
    int numUEAS;

    //constructores
    public Profesor(){
        super("", "", "");
        this.ueas = new UEA[3]; //solo poder agregar 3 clases
        this.numUEAS = 0;
    }
    
    public Profesor(String nombre, String apellPaterno, String apellMaterno, String numEconomico, String departamento){
        super(nombre, apellPaterno, apellMaterno);
        this.numEconomico = numEconomico;
        this.departamento = departamento;
        this.ueas = new UEA[3];
        this.numUEAS = 0;
    }

    //metodos
    public String toString(){
        String papa = super.toString();
        String estado = papa + ", Numero economico: " +numEconomico+
                                ", departamento: " + departamento;
        return estado;
    }

    public void agregarUEA(UEA nuevUEA){ // <-- Se usa 'nuevUEA' como parámetro
        //verificar si hay espacio
        if(this.numUEAS < this.ueas.length){
            //guardar la nueva UEA en la posicion actual
            //numUEAS es la posicion del primer espacio
            this.ueas[this.numUEAS] = nuevUEA; // <-- ¡Corregido el nombre de la variable!

            //aumentar el contador para apuntar a la siguiente posicion
            this.numUEAS++;
        } else {
            System.out.println("ERROR, el profesor ya tiene el maximo de UEAS para dar (3)");
        }
    }

    //para ver las ueas inscritas
    public void mostrarUEASInscritas(){
        System.out.println("\n*** UEAs inscritas por: " + this.nombre + " ***");

        //si aun no tiene inscritas
        if(this.numUEAS == 0){
            System.out.println("El profesor no tiene UEAs inscritas");
            return;
        }

        //si tiene algunas inscritas
        for(int i=0; i<this.numUEAS; i++){
            System.out.println(this.ueas[i].toString());
        }
        System.out.println("\nTotal de UEAs: " + this.numUEAS);
    }
}