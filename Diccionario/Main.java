package Diccionario;

import java.util.Scanner;

/*public class Main {

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
}*/

public class Main {

    public static void main(String[] args) {
        
        final String NOMBRE_ARCHIVO = "mi_diccionario.txt";
        Diccionario diccionario = new Diccionario();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        // 1. CARGAR DATOS AL INICIO
        System.out.println("--- Iniciando Diccionario ---");
        diccionario.cargar(NOMBRE_ARCHIVO);
        System.out.println("-----------------------------\n");
        
        do {
            System.out.println("\n===== MENÚ DE OPERACIONES =====");
            System.out.println("1. Agregar Palabra y Definición");
            System.out.println("2. Buscar Definición");
            System.out.println("3. Imprimir Diccionario Completo (Ordenado)");
            System.out.println("4. Guardar y Salir");
            System.out.print("Elige una opción: ");
            
            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine(); // Consumir el salto de línea
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
                entrada.nextLine();
                opcion = 0;
            }

            // --- Lógica del Menú ---
            switch (opcion) {
                case 1:
                    System.out.print("Palabra a agregar: ");
                    String palabraNueva = entrada.nextLine().trim();
                    System.out.print("Definición: ");
                    String definicionNueva = entrada.nextLine().trim();
                    
                    if (!palabraNueva.isEmpty() && !definicionNueva.isEmpty()) {
                        diccionario.agregarPalabra(palabraNueva, definicionNueva);
                        System.out.println("✔️ Palabra agregada/actualizada con éxito.");
                    } else {
                        System.out.println("⚠️ La palabra o definición no pueden estar vacías.");
                    }
                    break;

                case 2:
                    System.out.print("Palabra a buscar: ");
                    String terminoBusqueda = entrada.nextLine().trim();
                    
                    String resultado = diccionario.buscarPalabra(terminoBusqueda);
                    System.out.println("\n" + resultado);
                    break;

                case 3:
                    diccionario.imprimirDiccionario();
                    break;

                case 4:
                    // 2. GUARDAR DATOS AL SALIR
                    System.out.println("\n--- Guardando cambios y saliendo... ---");
                    diccionario.guardar(NOMBRE_ARCHIVO);
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    if (opcion != 4) {
                        System.out.println("Opción incorrecta, intenta de nuevo.");
                    }
            }
        } while (opcion != 4);
        
        entrada.close();
    }
}
