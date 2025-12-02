package Diccionario;

import java.util.ArrayList;

//esto va a tener la lista de las letras y palabras
public class Diccionario {
    //atributos
    private ArrayList<Letra> letras;

    //constructor
    public Diccionario(){
        this.letras = new ArrayList<>();
    }

    public void agregarPalabra(String palabra, String definicion){
        //toLowerCase es para dejar todo en minusculas
        String termino = palabra.toLowerCase(); //cambio a termino porqeu sino se duplica definicion
        if(termino.isEmpty()) return; //agrega una palabra pero crea una Letra si es necesario

        char inicial = termino.charAt(0); //primera letra del termino (definicion)
        Palabra nuevaPalabra = new Palabra(termino, definicion);

        //aqui va a buscar y crear la letra si no existe
        Letra letraEncontrada = buscarLetra(inicial);

        if(letraEncontrada != null){
            //si la letra ya existe, solo agregamos la palabra
            letraEncontrada.agregarPalabra(nuevaPalabra);
        } else {
            //pero si la letra no existe, se crea y se agrega la palabra
            Letra nuevaLetra = new Letra(inicial); //se crea la letra
            nuevaLetra.agregarPalabra(nuevaPalabra); //se le agrega la palabra
            this.letras.add(nuevaLetra); //se agrega a la lista de letras
        }
    }

    //aqui quiero que busque la letra para que la cree si es una palabra nueva con letra nueva
    private Letra buscarLetra(char inicial){
        for(Letra l : letras){
            if(l.getLetra() == inicial){
                return l;
            }
        }
        return null;
    }

    //aqui va a buscar la palabra
    public String buscarPalabra(String palabraABuscar){
        String terminoBuscado = palabraABuscar.toLowerCase();
        if (terminoBuscado.isEmpty()){
            return "ERROR, la palabra no existe";
        }

        char inicial = terminoBuscado.charAt(0); //para que busque por la primer letra

        Letra letraContenedora = buscarLetra(inicial); //aqui inicia la busqueda

        if(letraContenedora != null){ //si hay algo en la lista de letras...
            Palabra resultado = letraContenedora.buscarPalabra(terminoBuscado); //que busque la palabra a buscar por su letra

            if(resultado != null){ //si si encuentra una palabra, que imprima la palabra y la definicion
                return "Definicion de **" +resultado.getPalabra()+ "**: " +resultado.getDefinicion();
            }
        }
        //si no encuentra la palabra buscada, que retorne null
        return "Lo siento, la palabra '" +palabraABuscar+ "' no se encuentra en el diccionario";
    }
}
