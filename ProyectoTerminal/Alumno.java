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
        //primero debo verifiar si ya tiene un Proyecto, la funcion esta mas abjao
        if(tieneProyectoTipo(proyecto.tipoPT)){
            System.out.println("ERROR, el alumno" +this.nombreAlumno+ "ya trabaja en un proyecto de: " +proyecto.tipoPT);
            return;
        }
        this.proyectos.add(proyecto);
        System.out.println("Se ha agregado el proyecto de: " +proyecto.tipoPT+ "al alumno: " +this.nombreAlumno);
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

    //agrego un metodo para saber si un alumno ya esta trabajando en un proyecto
    public boolean tieneProyectoTipo(String tipoPT){
        for(ProyectoTerminal p: proyectos){
            if(p.tipoPT.equalsIgnoreCase(tipoPT)){
            return true;
            }
        }
        return false;
    }
}
