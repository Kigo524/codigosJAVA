public class Pentagono extends Figura{
    public double lado, apotema;

    public Pentagono(String color, double lado, double apotema){
        super(color);
        this.lado=lado;
        this.apotema=apotema;

        calcularArea();
        calcularPerimetro();
    }

    //primero el perimetro porque se ocupa para el area
    public void calcularPerimetro(){
        perimetro = 5 * lado;
    }

    //ahora si el area
    public void calcularArea(){
        //mejor lo pongo de nuevo por si solo se busca el area
        double perim = 5 * lado;
        area = (perim * apotema) / 2;
    }
}
