package Partido;

import java.util.ArrayList;
import java.util.List;

public class Usuario{

    //atributos
    public String nombre;
    public List<Boleto> boletos;

    //constructor
    public Usuario(String nombre){
        this.nombre = nombre;
        this.boletos= new ArrayList<>();
    }

    //metodos
    public Boleto comprarBoleto(int idPartido, Estadio e){
        //primero buscar el partido
        Partido partido = e.buscarPartido(idPartido);
        //si no lo encuentra....
        if (partido == null){
            System.out.println("ERROR, el partido no existe...");
            return null;
        }
        //verificar si el estadio esta lleno
        if(e.estaLleno()){
            System.out.println("ERROR, el estadio esta lleno");
            return null;
        }
        //si si encuentra el partido
        Boleto nuevoBoleto = new Boleto(partido); //creo el boleto
        //y lo agrego al usuario y al partido
        this.boletos.add(nuevoBoleto);
        partido.agregarBoleto(nuevoBoleto);

        System.out.println("Compra Exitosa!!" +nuevoBoleto.toString());
        return nuevoBoleto;
    }


}