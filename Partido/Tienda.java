package Partido;

public class Tienda {
    
    public static void main(String [] args){

        //se crea un estadio con capacidad de 10
        Estadio azteca = new Estadio("Estadio azteca", 10);
        System.out.println("Estadio creado...");

        //crear partidos
        Partido clasico = new Partido(101, "15-Diciembre-2025", "20:00", "America", "Chivas");
        Partido finalCopa = new Partido(102, "20-Enero-2026", "18:00", "Pumas", "Cruz Azul");

        azteca.ingresarPartido(clasico);
        azteca.ingresarPartido(finalCopa);
        System.out.println("Se han agregado los partidos...");

        azteca.imprimirPartidos();

        //crear usuarios
        Usuario juan = new Usuario("Juan Perez");
        Usuario ana = new Usuario("Ana Mendoza");

        //que compren boletos
        Boleto b1 = juan.comprarBoleto(101, azteca);
        Boleto b2 = juan.comprarBoleto(101, azteca);
        Boleto b3 = ana.comprarBoleto(102, azteca);
        Boleto b4 = ana.comprarBoleto(101, azteca);

        //comprar un boleto que no existe
        Boleto b5 = juan.comprarBoleto(201, azteca);

        //imprimir los boletos de juan
        juan.imprimirBoletos();

        //imprimir estado de los partidos
        azteca.imprimirPartidos();

        System.out.println("Ahora a cancelar boletos");

        //juan cancela su primer boleto
        juan.cancelarBoleto(b1.numBoleto);
        System.out.println("elminacion del boleto: " +b1.numBoleto+ "EXITOSA");

        //juan cancelata un boleto que no es suyo
        juan.cancelarBoleto(b4.numBoleto);

        juan.imprimirBoletos();
        azteca.imprimirPartidos();
    }
}
