public class Trapecio extends Figura{
    public double baseMay, baseMen, lado1, lado2, altura;

    public Trapecio(String color, double baseMay, double baseMen, double lado1, double lado2, double altura){
        super(color);
        this.baseMay=baseMay;
        this.baseMen=baseMen;
        this.lado1=lado1;
        this.lado2=lado2;
        this.altura=altura;

        calcularArea();
        calcularPerimetro();
    }

    public void calcularArea(){
        area= ((baseMay+baseMen) * altura) / 2;
    }

    public void calcularPerimetro(){
        perimetro = baseMay+baseMen+lado1+lado2;
    }
}
