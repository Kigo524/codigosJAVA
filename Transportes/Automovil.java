package Transportes;

public class Automovil implements Transporte {
    //atributos
    int velocidad;
    int numAsientos;

    //constructores
    public Automovil(){
        numAsientos=4;
    }

    public String frenar(int valor){
        velocidad = velocidad - valor;
        return "\n El automovil ha frenado y ahora la velocidad es de "+ velocidad+ "km/h\n";
    }

    public void acelerar(int valor){
        //queremos que sea progresivo de 10 en 10 km/s
        String cadena;
        int limite=valor/10;

        for(int i=0; i<limite; i++){
            velocidad = velocidad + 10;
            System.out.println("incrementando velocidad en automovil ... "+velocidad+ "km/h\n");

            if(velocidad + 10 > valor){
                velocidad = (valor - velocidad) + velocidad;
                break;
            }
        }

        cadena = "El automovil ya ha alcanzado la velocidad de " + velocidad + "km/h\n";

        if(velocidad > VELOCIDAD_MAX){
            cadena = cadena + "\nALERTA!! EXCESO DE VELOCIDAD!\n";
        }

        System.out.println(cadena);
    }

    public String toString(){
        String estado = "El automovil tiene " +numAsientos+ "asientos y va a una velocidad de " +velocidad+ "km/h\n";
        return estado;
    }
}
