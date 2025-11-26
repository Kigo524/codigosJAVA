package Partido;

import java.util.List;
import java.util.ArrayList;

public class Partido {
    public int id;
    public String fecha;
    public String hora;
    public String equipoA;
    public String equipoB;
    public List<Boleto> contBoletos;

    public Partido(int id, String fecha, String hora, String equipoA, String equipoB) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.contBoletos = new ArrayList<Boleto>();
    }

    //contar boletos
    public int contarBoletos(){
        return this.contBoletos.size(); //que devuelva la cantidad de elementos en la lista
    }
    //para agregar boletos
    public void agregarBoleto(Boleto b) {
        this.contBoletos.add(b);
    }

    //voy a usar booleano
    //Va a buscar el boleto por su numBoleto y lo elimina
    public boolean removerBoleto(int num){
        for(Boleto b: contBoletos) {
            if(b.numBoleto == num){
                return contBoletos.remove(b);
            }
        }
        System.out.println("El boleto a eliminar no se encuentra...");
        return false; //si el boleto no se encontro
    }

    public String toString(){
        return "Partido ID: " +id+ " | " +equipoA+ " vs " +equipoB+
                " | Fecha: " +fecha+ " | Boletos vendidos: " +contarBoletos();
    }
}
