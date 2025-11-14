public abstract class Producto {
	public String nombre;
	public double precio;

	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public abstract String calcular();

	public void imprimir() {
		System.out.println("Producto: " + nombre);
		System.out.println("Precio base: " + precio);
	}
}