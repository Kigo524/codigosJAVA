public class Prueba{
	public static void main (String [] args){
		Persona guillermo = new Persona();
		Persona guadalupe = new Persona("Guadalupe", "Mendoza", 51, "elefante");
		
		System.out.println("Imprimiendo estado del objeto guillermo: ");
		System.out.println(guillermo.toString());
		
		System.out.println("Imprimiendo estado del objeto guadalupe: ");
		System.out.println(guadalupe);
		
		guillermo.nombre="Guillermo";
		guillermo.apellido="Garcia";
		guillermo.edad=67;
		
		System.out.println("Imprimiendo estado del objeto guillermo: ");
		System.out.println(guillermo.toString());
		
		guadalupe.password="Ele34Fante";
		
		System.out.println("El password de guadalupe es: " +guadalupe.password);
	
	}
	
}