public class PruebaRectangulo{
	public static void main (String [] args){
		Rectangulo r1 = new Rectangulo(10.5, 5.5);
		System.out.println(r1);
		double area = r1.calculaArea();
		r1.calculaPerimetro();
		System.out.println(r1);
		System.out.println(area);
	}
	
}