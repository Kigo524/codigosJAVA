package Diccionario;

public class Main {

    public static void main(String[] args) {

        String NOMBRE_ARCHIVO = "diccionario.txt";
        Diccionario diccionario = new Diccionario();

        //que primero cargue el diccionario
        diccionario.cargar(NOMBRE_ARCHIVO);

        // ahora si agrego las palabras al diccionario
        diccionario.agregarPalabra("abeja", "insecto productor de miel");
        System.out.println("Palabra agregada con exito...");

        diccionario.agregarPalabra("orangutan", "animal que canta jazz agogo");

        //agrego otra palabra para ver si se ordena por letra
        diccionario.agregarPalabra("cabra", "animal que esta loco");

        diccionario.imprimirDiccionario();

        //para buscar palabras
        System.out.println("****PRUEBA DE BUSQUEDA DE PALABRA****");
        String busqueda1 = diccionario.buscarPalabra("orangutan");
        System.out.println(busqueda1);

        //que al final de agregar, eliminar y todo, que guarde el archivo
        diccionario.guardar(NOMBRE_ARCHIVO);
    }
}
