public class Rectangulo{
	//atributos
	public double base;
	public double altura;
	public double area;
	public double perimetro;
	
	
	//constructores
	public Rectangulo(){}
	
	public Rectangulo(double base, double altura){
		this.base=base;
		this.altura=altura;
	}
	
	//metodos
	public String toString(){
		String estado= "base: " + base + 
						", altura: " + altura +
						", area: " + area +
						", perimetro: " + perimetro;
		return estado;
	}
	
	public double calculaArea(){
		area = base*altura;
		return area;
	}
	
	public void calculaPerimetro(){
		perimetro= (2*base) + (2*altura);
	}
	
}