package Partido;

public class Boleto {
    //atributos
    public int numBoleto;
    public Partido p;
    //contador estatico para que no se repitan numeros de boletos
    public static int contadorBoletos =0;

    //constructor
    public Boleto(Partido p){
        //aumenta el contdor y lo agrega como numero de boleto
        this.numBoleto = contadorBoletos+1;
        this.p = p;
    }

    //metodos
    public String toString(){
        return "Boleto No. " +numBoleto+ " para: " +p.toString();
    }
}
