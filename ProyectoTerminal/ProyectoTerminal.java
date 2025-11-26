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
}
