package ProyectoF_Biblioteca;

import java.util.Scanner;
import java.util.List;

public class Main {

    //menu principal
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorBiblioteca gestor = new GestorBiblioteca();

        //carga de datos de prueba para que no empiecen vacios
        inicializarDatosPrueba(gestor);

        int opcionPrincipal= -1;
        while(opcionPrincipal != 0){
            //este va a ser el menu "Principal" para elegir cual el tipo de menu a mostrar
            System.out.println("**** SISTEMA DE BIBLIOTECA ****");
            System.out.println("1. Menu USUARIO (prestamos, consultas)");
            System.out.println("2. Menu biblioteca (administracion, reportes)");
            System.out.println("0. Salir");
            System.out.println(">>> Seleccione su rol: ");

            try{
                String entrada = scanner.nextLine();
                opcionPrincipal = Integer.parseInt(entrada);

                switch(opcionPrincipal){
                    case 1:
                        menuUsuario(scanner, gestor);
                        break;
                    case 2:
                        menuBiblioteca(scanner, gestor);
                        break;
                    case 0:
                        System.out.println("Guardando datos y saliendo... FALTA LOS ARCHIVOS");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR: Ingrese un numero");
            }
        }
        scanner.close();
    }

    //menu de usuario
    private static void menuUsuario(Scanner scanner, GestorBiblioteca gestor){
        System.out.println("\n--- IDENTIFICACION DE USUARIO ---");
        System.out.println("Ingrese su matricula para acceder: "); //para saber que usuario es (de los creados en la funcion del inicio)
        String matricula = scanner.nextLine();

        Usuario usuarioActual = gestor.buscarUsuario(matricula);
        if(usuarioActual == null){ //si no lo encuentra...
            System.out.println("Usuario no encontrado. Contacte a la biblioteca");
            return; //salir del menu por no encontrar al usaurio
        }
        System.out.println("Bienvenido, " +usuarioActual.getNombre());

        int opcion = -1;
        while (opcion != 0){
            System.out.println("\n--- MENU USUARIO --- ");
            System.out.println("1. Solicitar prestamo");
            System.out.println("2. Devolver prestamo");
            System.out.println("3. Buscar material por TITULO");
            System.out.println("4. Buscar material por AUTOR");
            System.out.println("5. Buscar material por ANIO");
            System.out.println("6. Ver mis prestamos actuales");
            System.out.println("0. Regresar al menu principal");
            System.out.println(">>> Opcion: ");

            try{
                opcion = Integer.parseInt(scanner.nextLine());
                switch(opcion){
                    case 1:
                        System.out.println("ID del material a prestar: ");
                        String idP = scanner.nextLine();
                        gestor.solicitarPrestamo(idP, matricula);
                        break;
                    case 2:
                        System.out.println("ID del material a devolver: ");
                        String idD = scanner.nextLine();
                        gestor.devolverMaterial(idD);
                        break;
                    case 3:
                        System.out.println("Titulo a buscar: ");
                        var resTit = gestor.buscarPorTitulo(scanner.nextLine());
                        mostrarResultados(resTit); //este metodo esta mas abajo
                        break;
                    case 4:
                        System.out.println("Autor a buscar: ");
                        var resAut = gestor.buscarPorAutor(scanner.nextLine());
                        mostrarResultados(resAut);
                        break;
                    case 5:
                        System.out.println("Anio a buscar: ");
                        try{ //aqui meto otro try para que el sistema sepa que hacer y pueda volver a intentarlo
                            int anio = Integer.parseInt(scanner.nextLine());
                            var resAnio = gestor.buscarPorAnio(anio);
                            mostrarResultados(resAnio);
                        } catch (NumberFormatException e){
                            System.out.println("ERROR: anio invalido");
                        }
                        break;
                    case 6:
                        System.out.println(usuarioActual.toString()); //porque el tostring ya muestra los prestamos del usuario
                        if(usuarioActual.getMisPrestamos().isEmpty()){
                            System.out.println("No tiene prestamos activos");
                        } else {
                            for(Prestamo p : usuarioActual.getMisPrestamos()){
                                System.out.println(p);
                            }
                        }
                        break;
                    case 0:
                        break; //solo que salga
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch(NumberFormatException e){
                System.out.println("ERROR: Ingrese un numero");
            }
        }
    }

    //menu de biblioteca
    private static void menuBiblioteca(Scanner scanner, GestorBiblioteca gestor){
        int opcion = -1;
        while(opcion != 0){
            System.out.println("\n--- MENU BIBLIOTECA (ADMINISTRACION) ---");
            System.out.println("1. Registrar nuevo material");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("3. Imprimir catalogo completo");
            System.out.println("4. Imprimir solo libros");
            System.out.println("5. Imprimir solo revistas");
            System.out.println("6. Imprimir solo articulos");
            System.out.println("7. Imprimir lista de usuarios");
            System.out.println("8. Ver historial de prestamos");
            System.out.println("0. Regresar al Menu principal");
            System.out.println(">>> Opcion: ");

            try{
                opcion = Integer.parseInt(scanner.nextLine());
                switch(opcion){
                    case 1:
                        registrarMaterialInteractivo(scanner, gestor); //la funcion esta mas abajo
                        break;
                    case 2:
                        registrarUsuarioInteractivo(scanner, gestor);
                        break;
                    case 3:
                        gestor.listarCatalogoCompleto();
                        break;
                    case 4:
                        gestor.listarMaterialPorTipo(Libro.class); //para que filtre solo los libros "<?>"
                        break;
                    case 5:
                        gestor.listarMaterialPorTipo(Revista.class);
                        break;
                    case 6:
                        gestor.listarMaterialPorTipo(Articulo.class);
                        break;
                    case 7:
                        gestor.listarUsuarios();
                        break;
                    case 8:
                        gestor.listarHistorialPrestamos();
                        break;
                    case 0:
                        break; //que solo salga
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch(NumberFormatException e){
                System.out.println("ERROR: Ingrese un numero.");
            }
        }
    }


    //metodos individuales
    private static void mostrarResultados(List<MaterialBibliografico> lista){
        if(lista.isEmpty()){
            System.out.println("No se encontraron resultados...");
        } else {
            for(MaterialBibliografico m : lista){
                System.out.println(m);
            }
        }
    }

    private static void inicializarDatosPrueba(GestorBiblioteca gestor){
        gestor.agregarMaterial(new Libro("L001", "Java para Principiantes", "Juan Perez", 2023, true, 450));
        gestor.agregarMaterial(new Revista("R001", "Tech Trends", "Varios", 2024, true, "Tech Weekly", 10, 2));
        gestor.registrarUsuario(new Usuario("Estudiante 1", "1001"));
        gestor.registrarUsuario(new Usuario("Admin prueba", "ADMIN"));
    }

    private static void registrarUsuarioInteractivo(Scanner scanner, GestorBiblioteca gestor){
        System.out.println("--- Nuevo usuario ---");
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Matricula: ");
        String matricula = scanner.nextLine();
        gestor.registrarUsuario(new Usuario(nombre, matricula)); //del gestor
    }

    private static void registrarMaterialInteractivo(Scanner scanner, GestorBiblioteca gestor){
        System.out.println("--- NUEVO MATERIAL ---");
        System.out.println("1. Libro  |  2. Revista  |  3. Articulo");
        System.out.println("Tipo: ");

        int tipo =-1;
        try{
            tipo = Integer.parseInt(scanner.nextLine());
        } catch(Exception e) {
            System.out.println("ERROR");
            return;
        }

        //aqui para los datos que van a registrar
        System.out.println("ID unico: ");
        String id = scanner.nextLine();
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        System.out.println("Anio: ");
        int anio= Integer.parseInt(scanner.nextLine());

        switch(tipo){
            case 1: //libro
                System.out.println("Numero de paginas: ");
                int pag = Integer.parseInt(scanner.nextLine());
                gestor.agregarMaterial(new Libro(id, titulo, autor, anio, true, pag));
                break;
            case 2://revista
                System.out.println("Nombre revista: ");
                String nomRev = scanner.nextLine();
                System.out.println("Volumen: ");
                int vol= Integer.parseInt(scanner.nextLine());
                System.out.println("Edicion: ");
                int ed= Integer.parseInt(scanner.nextLine());
                gestor.agregarMaterial(new Revista(id, titulo, autor, anio, true, nomRev, vol, ed));
                break;
            case 3://articulo
                System.out.println("Publicacion en la que se encuentra: ");
                String pub= scanner.nextLine();
                gestor.agregarMaterial(new Articulo(id, titulo, autor, anio, true, pub));
                break;
            default:
                System.out.println("Tipo de material no valido");
        }
    }
}

/*
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; //para la lista de resultados

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
*/