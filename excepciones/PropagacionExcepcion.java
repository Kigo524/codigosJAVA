package excepciones;

public class PropagacionExcepcion {
    public static void main(String [] args){
        System.out.println("Entrando a main...");
        try{
            tercerMetodo();
        }catch(ArithmeticException e){
            System.out.println("Ocurrio un error de tipo Aritmetico, por dividir un valor entre 0");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Estas intentando acceder a un indice que esta fuera del rango de tu arreglo");
        }catch(NullPointerException e){
            System.out.println("Estas intentando acceder a un elemento pero en el arreglo no hay ningun objeto en ese indice");
        }

        System.out.println("**** FIN DEL PROGRAMA ****");
    }

    public static void primerMetodo(){
        System.out.println("Primer metodo...");
        int k, r;
        r=0;
        //k=2/r; //arithmeticException

        //otra excepcion
        String [] miArreglo = new String[6];
        //miArreglo[8] = "luis"; //ArrayIndexOutOfBoundsException

        //para null pointer exception
        if(miArreglo[0].equals("Pablo")){ //null pointer exception
            System.out.println("Las cadenas son iguales");
        }
    }

    public static void segundoMetodo(){
        System.out.println("Segundo metodo...");
        primerMetodo();
    }

    public static void tercerMetodo(){
        System.out.println("Tercer metodo...");
        segundoMetodo();
    }
}
