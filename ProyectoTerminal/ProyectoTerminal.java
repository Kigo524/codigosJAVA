package ProyectoTerminal;

import java.util.ArrayList;
import java.util.List;

public class ProyectoTerminal {
    //atributos
    public String nombrePT;
    //agrego que tipo de pt es
    public String tipoPT;
    public List<Asesor> profes;

    public ProyectoTerminal(String nombrePT, String tipoPT){
        this.nombrePT = nombrePT;
        this.tipoPT = tipoPT;
        this.profes = new ArrayList<Asesor>();
    }

    public String toString(){
        return "| PT: " +nombrePT+ " | Clase: " +tipoPT;
    }

    public void agregarAsesor (Asesor profe){
        this.profes.add(profe);
    }

    //falta buscar asesor
    public Asesor buscarAsesor(int numEco){
        for(Asesor as: profes){
            //si encuentra el numEco
            if(as.numEconomico == numEco){
                System.out.println("Asesor " +as.nombreAsesor+ "encontrado... ");
                return as;
            }
        }
        System.out.println("ERROR, no se encontro el asesor con NumEco: " +numEco);
        return null;
    }
}
