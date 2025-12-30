package ProyectoF_Biblioteca_2243030419;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    //atributos
    private String nombre;
    private String matricula;
    private List<Prestamo> misPrestamos; //lista del usuario

    //constructor
    public Usuario(String nombre, String matricula){
        this.nombre=nombre;
        this.matricula=matricula;
        this.misPrestamos = new ArrayList<>(); //inicializando la lista de prestamos
    }

    //getters
    public String getNombre(){return nombre;}

    public String getMatricula(){return matricula;}

    //aqui creo que puedo agregar un getter de la lista para mas facil
    public List<Prestamo> getMisPrestamos(){return misPrestamos;}

    //aqui para agregar un prestamos a la lista del usuario
    public void agregarPrestamo(Prestamo prestamo){
        this.misPrestamos.add(prestamo);
    }

    //agrego un metodo toString para los datos
    public String toString(){
        return "Usuario: [Matricula: " +matricula+ ", Nombre: " +nombre+ ", Préstamos actuales: " +misPrestamos.size()+ "]";
    }
}
