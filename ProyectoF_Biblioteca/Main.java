package ProyectoF_Biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; //ara la lista de resultados

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorBiblioteca gestor = new GestorBiblioteca();

        //para prueba***********************
        Libro libro1 = new Libro("L001", "Programación Orientada a Objetos", "Juan Pérez", 2023, true, 450);
        Articulo articulo1 = new Articulo("A002", "El Futuro del Java", "Maria Lopez", 2024, true, "Java Journal");
        Libro libro2 = new Libro("L003", "Diseño de Algoritmos", "Carlos Ruiz", 2021, true, 600);
        Revista revista1 = new Revista("R001", "Ciencia Hoy", "Varios Autores", 2024, true, "Ciencia Hoy", 15, 3);

        gestor.agregarMaterial(libro1);
        gestor.agregarMaterial(articulo1);
        gestor.agregarMaterial(libro2);
        gestor.agregarMaterial(revista1);

        //aqui los usuarios de prueba
        Usuario usuarioA = new Usuario("Ana Garcia", "1001");
        Usuario usuarioB = new Usuario("Beto Flores", "1002");
        Usuario usuarioC = new Usuario("Carmen Cadena", "1003");

        gestor.registrarUsuario(usuarioA);
        gestor.registrarUsuario(usuarioB);
        gestor.registrarUsuario(usuarioC);

        System.out.println("*** INICIANDO CON DATOS DE PRUEBA ***");

        //aqui va el menu

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== MENÚ BIBLIOTECA =====");
            System.out.println("1. Listar Catálogo Completo");
            System.out.println("2. Buscar Material por Criterio");
            System.out.println("3. Realizar Préstamo");
            System.out.println("4. Devolver Material");
            System.out.println("0. Salir");
            System.out.print(">>> Ingrese una opción: ");

            //los try que nos pidio la maestra
            try{
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion){
                    case 1:
                        gestor.listarCatalogoCompleto();
                        break;
                    case 2:
                        //otro menu ara hacer la busqueda, porque pidieron muchas opciones de busqueda o filtros
                        int subOpcion = -1;
                        System.out.println("\n--- SUBMENÚ DE BÚSQUEDA ---");
                        System.out.println("1. Buscar por Título");
                        System.out.println("2. Buscar por Autor");
                        System.out.println("3. Buscar por Año de Publicación");
                        System.out.println("4. Mostrar solo Materiales Disponibles");
                        System.out.println("0. Volver al Menú Principal");
                        System.out.print("> Ingrese una opción de búsqueda: ");
                        
                        try {
                            subOpcion = Integer.parseInt(scanner.nextLine());
                            
                            // Llama al método auxiliar de búsqueda
                            ejecutarBusqueda(scanner, gestor, subOpcion); //se nota que me quedé sin nombres jajaja
                            
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Por favor, ingrese un número válido.");
                        }
                        break;
                    case 3:
                        realizarPrestamo(scanner, gestor); //usa un metodo de mas abajo
                        break;
                    case 4:
                        //es devolucion
                        devolverMaterial(scanner, gestor); //tambien esta abajo
                        break;
                    case 0:
                        System.out.println("Cerrando la Biblioteca...");
                        break;
                    default:
                        System.out.println("Opción no valida, intente de nuevo.");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("ERROR: Por favor, ingrese un número para la opción.");
                opcion = -1; //para que se repita el bucle
            }
        }
        scanner.close(); //todo esto fue el scanner
    }

    //estos se ocupan arriba
    //este es para el prestamo
    private static void realizarPrestamo(Scanner scanner, GestorBiblioteca gestor){
        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");
        System.out.println("Ingrese el ID del material a prestar (ej: L001, A002): ");
        String idMaterial = scanner.nextLine();

        System.out.println("Ingrese la matricula del usuario (ej: 1001, 1002): ");
        String matricula = scanner.nextLine();

        gestor.solicitarPrestamo(idMaterial, matricula); //llama al otro metodo
    }

    //este es para la devolucion
    private static void devolverMaterial(Scanner scanner, GestorBiblioteca gestor){
        System.out.println("\n--- REGISTRAR DEVOLUCIÓN ---");
        System.out.println("Ingrese el ID del material a devolver (ej: L001, A002): ");
        String idMaterial = scanner.nextLine();

        gestor.devolverMaterial(idMaterial); //llama al otro metodo
    }

    //ahora la opcion 2 de busccar, quiero hacer un menu o algo asi
    //ya me quedé sin nombres para los metodos jeje
    private static void ejecutarBusqueda(Scanner scanner, GestorBiblioteca gestor, int subOpcion){
        //creo de nuevo una lista para cada filtro
        List<MaterialBibliografico> resultados = new ArrayList<>();
        String terminoBusqueda;

        switch (subOpcion) {
            case 1:
                System.out.println("Ingrese el TITULO o la palabra clave: ");
                terminoBusqueda = scanner.nextLine();
                //lama al metodo de GestorBiblioteca
                resultados = gestor.buscarPorTitulo(terminoBusqueda);
                break;
            case 2:
                System.out.println("Ingrese el NOMBRE del autor: ");
                terminoBusqueda = scanner.nextLine();
                //llama al metodo de Gestor
                resultados = gestor.buscarPorAutor(terminoBusqueda);
                break;
            case 3:
                System.out.println("Ingrese el AÑO de publicacion (ej: 2023): ");
                try{ //para por si piden poner más try jeje
                    int anio = Integer.parseInt(scanner.nextLine());
                    //llama al metodo del Gestor
                    resultados = gestor.buscarPorAnio(anio);
                }catch(NumberFormatException e){
                    System.out.println("ERROR: El año debe ser un entero");
                    return; //sale del metodo
                }
                break;
            case 4:
                System.out.println("Mostrando los materiales DISPONIBLES...");
                //el metodo de gestion
                resultados = gestor.listarMaterialesDisponible();
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                return;
            default:
                System.out.println("Opción de búsqueda no válida");
                return;
        }
        
        //para los resultados...
        if(resultados.isEmpty()){
            System.out.println("\n---No se encontraron resultados...----");
        } else {
            System.out.println("\n---Resultados de busqueda (" +resultados.size()+ " encontrados) ---");
            for(MaterialBibliografico material : resultados){
                //aqui veo que por eso pidió polimorfismo, porque es mas facil imprimir
                System.out.println(material.toString());
            }
            System.out.println("------------------------------------------");
        }
    }
}
