public class Persona{
	//atributos
	public String nombre;
	public String apellido;
	public int edad;
	public String password;
	
	//contructores
	public Persona(){
		password="123";
	}
	
	public Persona(String nombre, String apellido, int edad, String password){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.password=password;
	}
	
	//metodos
	
	public String toString(){
		System.out.println("Imprimiento estado...");
		
		String estado = "nombre: " + nombre + ", " +
						"apellido: " + apellido + ", " +
						"edad: " + edad + ", " +
						"password: " + password;
						
		return estado;
		
	}
	
	

}