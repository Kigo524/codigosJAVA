import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PruebaConArchivos{
    public static void main(String [] args) {
        int op;
        Scanner entrada = new Scanner(System.in);
        String texto=null;
        do{
            System.out.println("\n1. Leer archivo \n2. Escribir archivo \n3. Salir");
            System.out.println("Elige una opcion:");
            op=entrada.nextInt();

            switch (op) {
                case 1:
                    leer();
                    break;
                
                case 2:
                    entrada.nextLine();
                    System.out.println("Inserta texto a escribir: ");
                    texto=entrada.nextLine();
                    escribir(texto);
                    break;
                
                case 3:
                    System.out.println("Hasta pronto!!");
                    break;
                
                default:
                    System.out.println("Opcion incorrecta, elige otra");
            }
        }while(op!=3);
    }

    public static void escribir (String texto){
        try{
            String nombreArchivo = "mi_archivo.txt";
            File archivo = new File(nombreArchivo);
            FileWriter fw= new FileWriter(archivo, true); //treu es para que escriba mas abajo del texto anterior
            fw.write(texto + "\n");
            fw.close();

            System.out.println("Se ha escrito el archivo");
        }catch(IOException e){
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leer(){
        try{
            String nombreArchivo = "mi_archivo.txt";
            File archivo = new File(nombreArchivo);
            FileReader fr = new FileReader(nombreArchivo);

            //va a leer caracter por caracter de nuestro archivo
            //tambien nos da el numero de caracteres en el archivo, por eso es con un ciclo

            int caracter;
            while((caracter=fr.read()) != -1){
                System.out.print((char) caracter);
            }

            fr.close();
        }catch(IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}