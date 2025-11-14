public abstract class Figura {
    public String color;
    public double area;
    public double perimetro;

    public Figura(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void imprimir() {
        System.out.println("Color: " + color);
        System.out.println("Area: " + area);
        System.out.println("Perimetro: " + perimetro);
    }

    //public abstract void imprimir();//metodo abstracto
    public abstract void calcularArea();
    public abstract void calcularPerimetro();
}