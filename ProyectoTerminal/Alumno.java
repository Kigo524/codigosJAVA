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

    public void imprimirProyectos(){
        for(ProyectoTerminal p: proyectos){
            //para imprimir los pt1
            if(p.tipoPT.equalsIgnoreCase("pt1")){
                System.out.println("-------- Proyectos de PT1: ---------");
                System.out.println(" " +p.toString());
                imprimirAsesores(p);
            }
        }

        for(ProyectoTerminal p: proyectos){
            //para imprimir los pt2
            if(p.tipoPT.equalsIgnoreCase("pt2")){
                System.out.println("\n -------- Proyectos de PT2: ---------");
                System.out.println(" " +p.toString());
                imprimirAsesores(p);
            }
        }

        for(ProyectoTerminal p: proyectos){
            //para imprimir los pt2
            if(p.tipoPT.equalsIgnoreCase("pt3")){
                System.out.println("\n -------- Proyectos de PT3: ---------");
                System.out.println(" " +p.toString());
                imprimirAsesores(p);
            }
        }
    }

    public void imprimirAsesores(ProyectoTerminal p){
        if(p.profes.isEmpty()){
            System.out.println("No hay profesores asigandos a este PT...");
        }
        System.out.println("Asesores: ");
        for(Asesor a: p.profes){
            System.out.println(" " +a.toString());
        }
    }
}
