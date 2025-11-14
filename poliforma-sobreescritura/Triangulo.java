public class Triangulo extends Figura {
    public double lado1, lado2, lado3;
    public double base, altura;

    public Triangulo(String color, double lado1, double lado2, double lado3, double base, double altura) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.base = base;
        this.altura = altura;
        calcularArea();
        calcularPerimetro();
    }

    public void calcularArea(){
        area= (base * altura) / 2;
    }
    public void calcularPerimetro(){
        perimetro = lado1 + lado2 + lado3;
    }
}
