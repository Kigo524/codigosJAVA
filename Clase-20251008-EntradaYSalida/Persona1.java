public class Persona1 {
    
    //constante fija que no cambia su valor con I de indefinido
    public static final char SEXO_DEFAULT = 'I';
    //atributos
    private String nombre;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;

    //constructores
    public Persona1(){
        this.sexo = SEXO_DEFAULT; 
    }

    public Persona1(String nombre, int edad, char sexo){
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
    }

    public Persona1(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
        this.peso=peso;
        this.altura=altura;
    }

    //metodos de acceso get y set
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

    public int getEdad(){
        return edad;
    }

    public void setSexo(char sexo){
        this.sexo=sexo;
    }

    public char getSexo(){
        return sexo;
    }

    public void setPeso(double peso){
        this.peso=peso;
    }

    public double getPeso(){
        return peso;
    }

    public void setAltura(double altura){
        this.altura=altura;
    }

    public double getAltura(){
        return altura;
    }

    //metodos
    public String toString(){
        String estado = "nombre: " +nombre+
                                ", edad: " +edad+
                                ", sexo: " +sexo+
                                ", peso: " +peso+
                                ", altura: " +altura;
        return estado;
    }

    public boolean esMayorDeEdad(){
        return this.edad <= 18;
    }
}
