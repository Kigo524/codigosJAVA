package Transportes;

public interface Transporte {

    //constante
    int VELOCIDAD_MAX=120;
    
    void acelerar(int valor);
    String frenar(int valor);
}