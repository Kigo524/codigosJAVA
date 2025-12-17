package ProyectoF_Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}