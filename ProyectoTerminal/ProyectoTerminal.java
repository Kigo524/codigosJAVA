package ProyectoTerminal;

import java.util.ArrayList;
import java.util.List;

public class ProyectoTerminal {
    //atributos
    public String nombrePT;
    public List<Asesor> profes;

    public ProyectoTerminal(String nombrePT){
        this.nombrePT = nombrePT;
        this.profes = new ArrayList<Asesor>();
    }

    public void agregarAsesor (Asesor profe){
        this.profes.add(profe);
    }
}
