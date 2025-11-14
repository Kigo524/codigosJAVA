public class Circulo extends Figura{
    public double radio;

    public Circulo(String color, double radio){
        super(color);
        this.radio = radio;
        calcularArea();
        calcularPerimetro();
    }

    public void calcularArea(){
        area = Math.PI * radio * radio;
    }

    public void calcularPerimetro(){
        perimetro = 2 * Math.PI * radio;
    }
}
