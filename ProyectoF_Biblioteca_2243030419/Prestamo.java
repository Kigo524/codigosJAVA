package ProyectoF_Biblioteca_2243030419;

import java.time.LocalDate;
import java.util.UUID; //para generar IDs unicos

public class Prestamo {
    //atributos
    private String idPrestamo;
    private MaterialBibliografico material;
    private String matriculaUsuario; //desde Usuario
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    //constructor
    public Prestamo(MaterialBibliografico material, String matriculaUsuario){
        this.idPrestamo=UUID.randomUUID().toString(); //esto es para que genere un id random en lugar de un contador
        this.material= material;
        this.matriculaUsuario=matriculaUsuario;
        this.fechaPrestamo=LocalDate.now(); //para la fecha de hoy
        this.fechaDevolucion=null; //inicia en null por si es fecha indeterminada
    }

    //getters y setters
    public String getIdPrestamo(){return idPrestamo;} //creo que no ncesito set de esto

    public MaterialBibliografico getMaterial(){return material;}

    public String getMatriculaUsuario(){return matriculaUsuario;}

    public LocalDate getFechaPrestamo(){return fechaPrestamo;}

    public LocalDate getFechaDevolucion(){return fechaDevolucion;}
    public void setFechaDevolucion(LocalDate fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion; //ahora si por si hay que registrar fecha de devuelto
    }

    //toString para que haga de ticket del prestamo
    public String toString(){
        String estado = (fechaDevolucion == null) ? "ACTIVO" : "DEVUELTO";
        return "***Prestamo " +estado+ " *** \n"+
                "ID: " +idPrestamo+ "\n"+
                "Material: " +material.getTitulo()+ " (ID: " +material.getId()+ ")\n"+
                "Matricula de Usuario: " +matriculaUsuario+ "\n"+
                "Fecha Préstamo: " +fechaPrestamo+ "\n"+
                "Fecha Devolución: " +(fechaDevolucion != null ? fechaDevolucion.toString() : "PENDIENTE");
                //aqui uso el operador ternario, aqui arriba
    }
}
