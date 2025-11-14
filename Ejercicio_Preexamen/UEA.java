package Ejercicio_Preexamen;

public class UEA {
    //atributos
    public String nombreUEA;
    public String claveUEA;
    public String grupoUEA;

    public UEA(){}

    public UEA(String nombreUEA, String claveUEA, String grupoUEA){
        this.nombreUEA= nombreUEA;
        this.claveUEA= claveUEA;
        this.grupoUEA= grupoUEA;
    }

    public String toString(){
        String estado = "nombre: "+nombreUEA+
                        ", clave: "+claveUEA+
                        ", grupo: "+grupoUEA;
        return estado;
    }
}
