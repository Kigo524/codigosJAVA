package ProyectoTerminal;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    //atributos
    public String nombreAlumno;
    public int matricula;
    public List<ProyectoTerminal> proyectos;

    public Alumno(String nombreAlumno, int matricula){
        this.nombreAlumno = nombreAlumno;
        this.matricula = matricula;
        this.proyectos = new ArrayList<ProyectoTerminal>();
    }

    public String toString(){
        return "| Alumno: " +nombreAlumno+ " | Matricula: " +matricula;
    }

    public void agregarProyecto(ProyectoTerminal proyecto){
        this.proyectos.add(proyecto);
    }

    public void imprimirProyectos(ProyectoTerminal p){
        for(ProyectoTerminal p: proyectos){
            System.out.println(toString());
        }
    }
}
