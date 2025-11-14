package Transportes;

public class Moto implements Transporte{
    //atributos
    int velocidad;
    String sistemaArranque; //electrico o pedal

    //constructor
    public Moto(){
        sistemaArranque = "pedal";
    }

    public String frenar(int valor){
        velocidad = velocidad - valor;
        return "\n La moto ha frenado y ahora la velocidad es de "+ velocidad+ "km/h\n";
    }

    public void acelerar(int valor){
        String cadena;
        int limite = valor / 5;
        int residuo = valor % 5;

        for(int i=0; i<limite; i++){
            velocidad = velocidad + 5;
            System.out.println("Incrementando velocidad en moto..." +velocidad+ "km/h\n");
        }

        if(residuo > 0){
            velocidad = velocidad + residuo;
            System.out.println("Incrementando velocidad en moto..." +velocidad+ "km/h\n");
        }

        cadena = "La moto ya ha alcanzado la velocidad de " +velocidad+ "km/h\n";

        if(velocidad > VELOCIDAD_MAX){
            cadena = cadena + "\nALERTA! EXCESO DE VELOCIDAD";
        }

        System.out.println(cadena);
    }

    public String toString(){
        String estado = "La moto tiene un arranque de tipo " +sistemaArranque+ " y va a una velocidad de " +velocidad+ "km/h\n";
        return estado;
    }
}
