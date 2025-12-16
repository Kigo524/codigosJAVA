package ProyectoF_Biblioteca;

import java.time.LocalDate;

public class Prestamo {
    //atributos
    private String idPrestamo;
    private MaterialBibliografico material;
    private String matriculaUsuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(String idPrestamo, MaterialBibliografico material, String matriculaUsuario){
        this.idPrestamo=idPrestamo;
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
}
