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

    
}