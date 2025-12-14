package ProyectoF_Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    //atributos
    private List<MaterialBibliografico> catalogo;

    //constructor para crear la lista
    public GestorBiblioteca(){
        this.catalogo= new ArrayList<>();
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
}