package Partido;

import java.util.ArrayList;
import java.util.List;

public class Estadio {
    //atributos
    public String nombre;
    public int capacidad;
    public List<Partido> partidos;

    //constructor
    public Estadio(String nombre, int capacidad){
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.partidos = new ArrayList<>();
    }

    //metodos
    public void ingresarPartido(Partido p){
        this.partidos.add(p);
    }

    public Partido buscarPartido(int id){
        for(Partido p: partidos){
            if(p.id == id){ //si el id del Partido coincide con lo buscamos...
                System.out.println("Partido encontrado ...");
                return p;
            }
        }
        System.out.println("\nNo se encontro el partido...");
        return null;
    }

    public boolean estaLleno(){
        int totalBoletosVendidos = 0; //solo como variable aqui
        for(Partido p: partidos){ //buscamos en los partidos
            totalBoletosVendidos += p.contarBoletos(); //los boletos contados se suman a totalBoletosVendidos
            if(totalBoletosVendidos >= capacidad){ //si supera la capacidad...
                System.out.println("BOLETOS AGOTADOS...");
                return true;
            }
        }
        return false;
    }

    public void imprimirPartidos(){
        for(Partido p: partidos){
            System.out.print(p.toString());
            System.out.println("\n---------------------------------------------");
        }
    }
}
