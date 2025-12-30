package ProyectoF_Biblioteca_2243030419;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//para los txt
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDate;
//los de arriba son para txt

public class GestorBiblioteca {
    //atributos
    private List<MaterialBibliografico> catalogo;
    //despuesde crear Prestamo y Usuario agrego el otro
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    //constructor para crear la lista
    public GestorBiblioteca(){
        this.catalogo= new ArrayList<>();
        //tambien aqui agrego usuarios y prestamos
        this.usuarios= new ArrayList<>();
        this.prestamos= new ArrayList<>();
    }

    //metodo para agregar a la lista
    public void agregarMaterial(MaterialBibliografico material){
        this.catalogo.add(material);
        System.out.println("Se ha agregado el material: " +material.getTitulo());
    }

    public void listarCatalogoCompleto() {
        //Verificar si el catálogo está vacío
        if(catalogo.isEmpty()){
            System.out.println("El catálogo está vacío...");
        }
        //Si no está vacío, recorrer la lista con el método polimórfico
        System.out.println("Catálogo de articulos **************************** \n");
        for(MaterialBibliografico m : catalogo){
            System.out.println(" " +m.toString()); //para el tostring de cada elemento segun corresponda
        }
        System.out.println("**************************** \n");
    }

    //aqui el metodo va a buscar materiales por titulo y devolver los que coincidam
    //necesito que los que coinciden los ponga en una lista
    public List<MaterialBibliografico> buscarPorTitulo(String tituloBusqueda){
        //ahora creo la lista vacia y que se cree solo en lo que se usa el metodo
        List<MaterialBibliografico> resultados = new ArrayList<>();

        //aqui es para que se normalice la busqueda sin importar las mayusculas
        String tituloNormalizado= tituloBusqueda.toLowerCase();

        //Ahora si agrego el recorrido del catalogo
        //tiene que recorrer todo el catalogo
        for(MaterialBibliografico material : catalogo){
            String tituloMaterial = material.getTitulo().toLowerCase(); //la lista que tengo de Material bibliografico

            //para comparar uso .contains() para encontrar mas coincidencias
            //para que si escribo POO encuentre "Libro de POO"
            //que busque: si el titulo del material contiene la palabra buscada...
            if(tituloMaterial.contains(tituloNormalizado)){
                //si encuentra una coincidencia la agrega a la lista provicional
                resultados.add(material);
            }
        }

        return resultados;
    }

    //para el buscar por autor es practicamente el mismo codigo de arriba
    public List<MaterialBibliografico> buscarPorAutor(String autorBusqueda){
        //creo la lista vacia y qeu solo se use mientras se usa el metodo
        List<MaterialBibliografico> resultados = new ArrayList<>();

        //aqui es para normalizar la busqueda sin importar mayusculas
        String autorNormalizado = autorBusqueda.toLowerCase();

        //aqui el recorrido del catalogo
        for(MaterialBibliografico material : catalogo){
            String autorMaterial = material.getAutor().toLowerCase();

            //la comparativa sigo usando .contains para que ecneuntra algo parcial
            if(autorMaterial.contains(autorNormalizado)){
                resultados.add(material);
            }
        }
        return resultados;
    }

    //ahora va a la busqueda por año, aqui ya no necesito .contains
    //sigo creando la lista temporal para el metodo
    public List<MaterialBibliografico> buscarPorAnio(int anioBusqueda){
        //creo la lista vacia 
        List<MaterialBibliografico> resultados = new ArrayList<>();

        //que recorra todo el catalogo
        for(MaterialBibliografico material : catalogo){
            int anioMaterial = material.getAnioPublicacion();

            if(anioMaterial == anioBusqueda){
                resultados.add(material);
            }
        }
        return resultados;
    }

    //ahora copio el de buscarPorAnio para el materialDsiponible
    public List<MaterialBibliografico> listarMaterialesDisponible(){
        //creo la lista vacia
        List<MaterialBibliografico> resultados = new ArrayList<>();

        //aqui recorre todo el catalogo
        for(MaterialBibliografico material : catalogo){

            if(material.isDisponible()){
                resultados.add(material);
            }
        }
        return resultados;
    }

    //------Aqui va la parte despues de crear Usuario y Prestamo-----
    //ahora neccesito ver como gestionar catalogo, usuarios y preastamos

    public void registrarUsuario(Usuario usuario){
        //para agregar al usuario a la lista this.usuarios
        usuarios.add(usuario);
        System.out.println("Usuario Registrado: " +usuario.getNombre());
    }

    //lo voy a hacer para buscar por matricula
    public Usuario buscarUsuario(String matricula){
        //recorre la lista de usuarios
        for(Usuario u : usuarios){
            if(u.getMatricula().equalsIgnoreCase(matricula)){
                return u;
            }
        }
        return null; //si no encuentra la matricula
    }

    //aqui ahora es para los prestamos************************
    public boolean solicitarPrestamo(String idMaterial, String matriculaUsuario){
        //buscar el material
        MaterialBibliografico material = buscarMaterialPorId(idMaterial);
        if(material == null){//si no encuentra el material...
            System.out.println("ERROR: Material con ID " +idMaterial+ " no encontrado");
            return false;
        }

        //buscar usuario
        Usuario usuario = buscarUsuario(matriculaUsuario);
        if(usuario == null){
            System.out.println("ERROR: Usuario con matricula " +matriculaUsuario+ "no encontrada");
            return false;
        }

        //verificar disponibilidad
        if(!material.isDisponible()){ //si no esta disponible
            System.out.println("ERROR: " +material.getTitulo()+ " no esta disponible");
            return false;
        }
        
        //procesar el prestamo
        material.setDisponible(false); //cambio el estado del material

        Prestamo nuevoPrestamo = new Prestamo(material, matriculaUsuario); //creo el Prestamo

        this.prestamos.add(nuevoPrestamo); //registro el prestamo en la lista del Gestor

        usuario.agregarPrestamo(nuevoPrestamo); //lo registro tambien en la lista del Usuario

        //si se presta con exito...
        System.out.println("Prestamo EXITOSO: " +material.getTitulo()+ " prestamo a " +usuario.getNombre());
        System.out.println(nuevoPrestamo.toString());
        return true;
    }

    //tambien necesito una funcion para buscar por ID el mateiral para lo de arriba
    private MaterialBibliografico buscarMaterialPorId(String id){
        for(MaterialBibliografico material : catalogo){
            if(material.getId().equalsIgnoreCase(id)){
                return material;
            }
        }
        return null; //si no encuentra
    }

    //ahora voy con la devolución
    //necesito que haga algo para confirmar que esta prestado el material
    private Prestamo buscarPrestamoActivo(String idMaterial){
        for(Prestamo p : prestamos){
            //si el prestamo esta activo, osea que fechaDevolucion = null...
            if(p.getMaterial().getId().equalsIgnoreCase(idMaterial) && p.getFechaDevolucion() == null){
                return p;
            }
        }
        return null;
    }

    public boolean devolverMaterial(String idMaterial){
        //buscar el prestamo activo
        Prestamo prestamo = buscarPrestamoActivo(idMaterial);
        if(prestamo == null){
            System.out.println("ERROR: No se encontro un préstamo ACTIVO para el ID de material: " +idMaterial);
            return false;
        }

        //cachar el material
        MaterialBibliografico material = prestamo.getMaterial();

        //cambio el estado del material en la devolucion
        material.setDisponible(true);

        //ahora si registro la fecha de devolucion 
        prestamo.setFechaDevolucion(LocalDate.now()); //que sea la misma que el prestamo

        //no se si sea mejor quitarlo de la lista de usuario o dejarlo y marcarlo como devuelto
        //como para llevar el historial de prestamos

        System.out.println("Devolución exitosa del material: " +material.getTitulo());
        System.out.println("El material ya está disponible en el catálogo.");
        return true;
    }

    //*****aqui van mas metodos para el modo "administrador" */
    public void listarUsuarios(){
        if(usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados...");
        } else {
            System.out.println("--- Lista de usuarios registrados ---");
            for(Usuario u : usuarios) {
                System.out.println(u.toString());
            }
        }
    }

    //para el historial de prestamos pero de todos
    public void listarHistorialPrestamos(){
        if(prestamos.isEmpty()){
            System.out.println("No hay registro de prestamos en el historial");
        } else {
            System.out.println("--- Historial completo de prestamos ---");
            for(Prestamo p : prestamos){
                System.out.println(p.toString());
            }
        }
    }

    //la tarea pide listar por tipo de material
    //encontre que se usa "Class<?>" para filtar por clase
    public void listarMaterialPorTipo(Class<?> tipoClass){
        System.out.println("--- Listando: " +tipoClass.getSimpleName()+ " ---");
        boolean encontrado = false;
        for(MaterialBibliografico m : catalogo){
            //verifica si m se encuentra en la clase solicitada
            if(tipoClass.isInstance(m)){
                System.out.println(m.toString());
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No hay material de este tipo...");
        }
    }

    //para los txt, voy a separar los objetos por simbolos
    public void guardarDatos(){
        guardarCatalogo();
        guardarUsuarios();
        guardarPrestamos();
    }

    private void guardarCatalogo(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("catalogo.txt"))){
            //que se cree una linea de texto por cada objeto
            for(MaterialBibliografico m : catalogo){
                String linea = m.getClass().getSimpleName() + "|" + m.getId() + "|" + m.getTitulo() + "|" + 
                                m.getAutor() + "|" + m.getAnioPublicacion() + "|" + m.isDisponible();
                
                if(m instanceof Libro) {linea += "|" +((Libro) m).getNumPaginas();}
                else if(m instanceof Revista) {linea += "|" +((Revista) m).getNombreRevista()+
                                            "|"+ ((Revista) m).getNumVolumen()+ "|"+ ((Revista) m).getNumEdicion();}
                else if(m instanceof Articulo) {linea += "|"+ ((Articulo) m).getNombrePublicacionContenedora();}

                writer.println(linea);
                }
            }
        catch(IOException e) {System.out.println("ERROR al guardar catalogo: " +e.getMessage());}
    }

    private void guardarUsuarios(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("usuario.txt"))){
            for(Usuario u : usuarios){//que cree una linea por cada objeto separado por el |
                writer.println(u.getNombre() +"|"+ u.getMatricula());
            }
        } catch(IOException e){
            System.out.println("ERROR al guardar usuarios: " +e.getMessage());
        }
    }

    private void guardarPrestamos(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("prestamos.txt"))){
            for(Prestamo p: prestamos){
                //se guarda ID material y matricula para reconstruir el vinculo al cargar
                String fechaDev = (p.getFechaDevolucion() != null) ? p.getFechaDevolucion().toString() : "null";
                    writer.println(p.getMaterial().getId() + "|" + p.getMatriculaUsuario() + "|" + 
                    p.getFechaPrestamo() + "|" + fechaDev + "|" + p.getIdPrestamo());
            }
        } catch(IOException e) {System.out.println("ERROR al guardar prestamos: " +e.getMessage());}
    }

    public void cargarDatos(){
        cargarUsuaios();
        //cargarCatalogo();
        //cargarPrestamos();
    }

    private void cargarUsuaios(){
        File archivo = new File("usuarios.txt");
        if(!archivo.exists()){
            return;
        }
        try(Scanner reader = new Scanner(archivo)){
            while(reader.hasNextLine()){
                String[] datos = reader.nextLine().split("\\|");
                usuarios.add(new Usuario(datos[0], datos[1]));
            }
        } catch(FileNotFoundException e) { }
    }

    //y hasta aqui le dejo porque son las 3:40 am y tengo que prepararme para la esculea

    /*
    private void cargarCatalogo(){
        File archivo = new File("catalogo.txt");
        if(!archivo.exists()) return;
        try(Scanner reader = new Scanner(archivo)){
            while(reader.hasNextLine()){
                String[] d = reader.nextLine().split("\\|");
                String tipo = d[0];
                boolean disp = Boolean.parseBoolean(d[5]);

                if(tipo.equals("Libro")){
                    catalogo.add(new Libro(d, tipo, tipo, 0, disp, 0))
                }
            }
        }
    }*/
}