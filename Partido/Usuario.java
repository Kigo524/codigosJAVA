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

    public void imprimirBoletos(){
        System.out.println("\n---- Boletos de: " +this.nombre+ "----");
        if(boletos.isEmpty()){
            System.out.println("No tiene ningun boleto comprado...");
            return;
        }
        for(Boleto b: boletos){
            System.out.println(b.toString());
        }
        System.out.println("-----------------------------------");
    }

    public boolean cancelarBoleto(int num){
        Boleto boletoACancelar = null;

        //primero a buscar el boleto
        for(Boleto b: boletos){
            if(b.numBoleto == num){
                boletoACancelar = b;
                break;
            }
        }

        if(boletoACancelar != null){
            //elimina el boleto del partido
            boletoACancelar.p.removerBoleto(num);
            //elmina del usuario tambien
            this.boletos.remove(boletoACancelar);

            System.out.println("El boleto No: " +num+ " ha sido cancelado exitosamente...");
            return true;
        }

        //si falla el if de encontrarlo...
        //si llega null aun...
        System.out.println("ERROR, no se encuentra ese boleto en la litsa...");
        return false;
    }
}