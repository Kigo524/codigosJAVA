package Ejercicio_2_Preexamen;

public class Blockbuster {

    //metodo para buscar y rentar producto
    public static void realizarRenta(Usuario usuario, Producto producto){
        System.out.println("Intentando la renta de: "+ producto.titulo+ " para: "+ usuario.nombre);

        if(producto.estaDisponible()){
            boolean exitoRenta = usuario.rentarProducto(producto);
            if(exitoRenta){
                producto.establecerDisponible(false); //lo marcamos como NO disponible
                System.out.println("Renta exitosa, el producto: "+producto.titulo+ " ha sido guardado c:");
            } else {
                System.out.println("Renta fallida, el usuario: "+usuario.nombre+" ha alcanzado su limite de rentas :c");
            }
        } else {
            System.out.println("Renta fallida, el producto: "+producto.titulo+ "NO ESTA DISPONIBLE");
        }
    }

    //metodo para devolver producto
    public static void realizarDevolucion(Usuario usuario, Producto producto){
        System.out.println(">>>Intentando la devolucion de: " +producto.titulo+ " del usuario: "+usuario.nombre);

        //1.Intentar quitar el producto del arreglo del usuario
        boolean exitoDevolucion = usuario.devolverProducto(producto);

        if(exitoDevolucion){
            //2. marcar el producto como disponible
            producto.establecerDisponible(true);
            System.out.println("Devolucion EXITOSA del producto: "+producto.titulo+ " Disponible de nuevo.");
        } else {
            System.out.println("Devolucion FALLIDA del producto: "+producto.titulo+ " ya que no fue encontrado con el usuario: "+usuario.nombre);
        }
    }
    public static void main(String [] args){
        
        Pelicula [] peliculas = new Pelicula[8];

        Pelicula LVEB = new Pelicula("01", "La Vida es Bella", "Drama", "1997", "116 minutos");
        Pelicula YADT = new Pelicula("02", "Yo antes de Ti", "Romance", "2016", "110 minutos");
        Pelicula MI = new Pelicula("03", "Milagros inesperados", "Drama", "1999", "180 minutos");
        Pelicula RL = new Pelicula("04","El Rey Leon","Fantasia","1994","85 minutos");
        Pelicula RSR = new Pelicula("05", "Rescatando al Soldado Rayan", "Belico", "1998", "170 minutos");
        Pelicula TT = new Pelicula("06", "Titanic", "Romance", "1997", "195 minutos");
        Pelicula MP = new Pelicula("07", "Matrix", "Ciencia Ficción", "1999", "136 minutos");
        Pelicula SR = new Pelicula("08", "Shrek", "Animación", "2001", "90 minutos");

        Serie [] series = new Serie[8];

        Serie BM = new Serie("11", "Black mirror", "ciencia ficción","2011", "5 temporadas");
        Serie HTGAWM = new Serie("12", "How to get away with murder", "drama legal", "2014", "6 temporadas");
        Serie ST = new Serie("13", "Stranger things", "ciencia ficción", "2016", "4 temporadas");
        Serie MF = new Serie("14", "Manifiesto", "drama sobrenatural", "2018", "4 temporadas");
        Serie TC = new Serie("15", "The Crown", "drama histórico", "2016", "5 temporadas");
        Serie BB = new Serie("16", "Breaking Bad", "Drama criminal", "2008", "5 temporadas");
        Serie FR = new Serie("17", "Friends", "Comedia", "1994", "10 temporadas");
        Serie TM = new Serie("18", "The Mandalorian", "Ciencia ficción", "2019", "3 temporadas");

        Videojuego [] videojuegos = new Videojuego[8];

        Videojuego MK = new Videojuego("21", "Mario kart", "carreras", "Nintendo", "4 jugadores");
        Videojuego CB = new Videojuego("22", "Crash Bandicoot", "mini juegos", "PlayStation", "1 jugador");
        Videojuego FF = new Videojuego("23", "FIFA 22", "deportes", "Xbox", "4 jugadores");
        Videojuego MB = new Videojuego("24", "Mario Bros", "mini juegos", "Nintendo", "4 jugadores");
        Videojuego MC = new Videojuego("25","Minecraft", "construcción", "Nintendo switch", "1 jugador");
        Videojuego ZL = new Videojuego("26", "Zelda", "aventura", "Nintendo", "1 jugador");
        Videojuego PK = new Videojuego("27", "Pokemon", "RPG", "Nintendo", "1 jugador");
        Videojuego GT = new Videojuego("28", "Gran Turismo", "carreras", "PlayStation", "2 jugadores");
        
        Usuario [] usuarios = new Usuario[3];

        Usuario FER = new Usuario("Fernanda", "fernanda31@patitofeo.com", "1234");
        Usuario DAN = new Usuario("Daniel", "daniel@patitofeo.com", "3984");
        Usuario LEO = new Usuario("Leonardo", "leonardo@patitofeo.com", "2938");

        System.out.println("==== INICIO DE RENTAS ====");
        
        // 1. Renta exitosa
        realizarRenta(FER, LVEB);
        // 2. Renta exitosa de un tipo diferente
        realizarRenta(FER, BM);
        
        // 3. Intento de rentar un producto ya rentado (debe fallar)
        realizarRenta(DAN, LVEB); 

        // 4. Renta exitosa para otro usuario
        realizarRenta(DAN, ZL);

        // 5. Múltiples rentas para un usuario (probando el límite de 5)
        realizarRenta(LEO, YADT);
        realizarRenta(LEO, RSR);
        realizarRenta(LEO, MP);
        realizarRenta(LEO, TT);
        realizarRenta(LEO, HTGAWM);
        // 6. Intento de superar el límite (debe fallar)
        realizarRenta(LEO, FR);
        
        System.out.println("\n==== REPORTE FINAL ====");

        //ahora para mostrar los productos rentados
        System.out.println("\n--- Productos de "+FER.nombre+ "---");
        for(int i=0; i<FER.contProduct; i++){
            System.out.println(" - "+FER.rentados[i].titulo);
        }

        // Para devoluciones
        System.out.println("\n==== INICIO DE DEVOLUCIONES ====");

        //FER devuelve LVEB
        realizarDevolucion(FER, LVEB);

        //Intento de rentar el producto devuelto (debe ser exitoso)
        realizarRenta(DAN, LVEB);

        //Intento de devolver algo que el usuario no tiene (debe fallar)
        realizarDevolucion(FER, ZL); 

        System.out.println("\n==== REPORTE FINAL DESPUÉS DE DEVOLUCIÓN ====");

        // Mostrar los productos rentados por los usuarios después de las transacciones
        System.out.println("\n--- Productos de " + FER.nombre + " ---");
        //Si LVEB fue devuelta, solo debe aparecer BM
        for (int i = 0; i < FER.contProduct; i++) {
            System.out.println(" - " + FER.rentados[i].titulo);
        }

        System.out.println("\n--- Productos de " + DAN.nombre + " ---");
        //Ahora debe tener ZL y LVEB
        for (int i = 0; i < DAN.contProduct; i++) {
            System.out.println(" - " + DAN.rentados[i].titulo);
        }

        }
    }
