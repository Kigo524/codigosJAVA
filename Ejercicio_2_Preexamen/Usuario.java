package Ejercicio_2_Preexamen;

    //attributos
public class Usuario {
    public String nombre;
    public String correo;
    public String telefono;
    //array para guardar productos rentados
    public Producto [] rentados;
    public int contProduct; //para saber cuantos van

    //constructores
    public Usuario(){}

    public Usuario(String nombre, String correo, String telefono){
        this.nombre= nombre;
        this.correo= correo;
        this.telefono= telefono;
        //inicializando el array y el contador
        this.rentados = new Producto[5];
        this.contProduct = 0;
    }

    //metodo para rentar un producto
    public boolean rentarProducto(Producto producto){
        if(contProduct < rentados.length){
            this.rentados[contProduct] = producto;
            this.contProduct++;
            return true;
        } else {
            //se supera el limite de renta
            return false;
        }
    }

    public boolean devolverProducto(Producto productoADevolver){
        for(int i=0; i<contProduct; i++){
            //compara si el producto en i se quiere devolver
            if(this.rentados[i] == productoADevolver){

                //1. desplazar los elementos a la izquierda para cubrir el hueco
                for(int j=0; j<contProduct - 1; j++){
                    this.rentados[j] = this.rentados [j+1];
                }

                //2. limpiar la ultima posicion y actualizar el contador
                this.rentados[contProduct - 1]=null;
                this.contProduct--;

                return true; //devlucion exitosa
            }
        }
        return false; //el producto no fue encontrado en rentados del usuario
    }

    //metodo toString
    public String toString(){
        String estado = "NOMBRE: "+nombre+ " CORREO: "+correo+ " TELEFONO: "+telefono;
        return estado;
    }
}
