public class Cuadrado extends Figura {
    public double lado;

    public Cuadrado(String color, double lado) {
        super(color);
        this.lado = lado;
        calcularArea();
        calcularPerimetro();
    }

    public void calcularArea() {
        area = lado * lado;
    }

    public void calcularPerimetro() {
        perimetro = 4 * lado;
    }
}