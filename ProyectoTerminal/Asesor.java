package ProyectoTerminal;

public class Asesor {
    //atributos
    public String nombreAsesor;
    public int numEconomico;
    public String departamento;

    public Asesor(String nombreAsesor, int numEconomico, String departamento){
        this.nombreAsesor = nombreAsesor;
        this.numEconomico = numEconomico;
        this.departamento = departamento;
    }

    public String toString(){
        return "| NumEco: " +numEconomico+ " | Profesor: " +nombreAsesor+ " | Depto: " +departamento;
    }
}
