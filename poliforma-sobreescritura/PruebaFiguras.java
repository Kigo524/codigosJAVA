public class PruebaFiguras {
    
    public static void main(String [] args){

        //cuadrado lado=5
        Cuadrado c1 = new Cuadrado("Azul", 5.0);

        //circulo readio =3
        Circulo circ1 = new Circulo("Rojo", 3.0);

        //triangulo lados: 3, 4, 5, base 3, altura 4
        Triangulo t1 = new Triangulo("Verde", 3, 4, 5, 3, 4);

        //trapecio base mayor 10, base menor 6, lado1=4, lado2=4, altura 3
        Trapecio tr1 = new Trapecio("Amarillo", 10, 6, 4, 4, 3);

        //voy a intentar un arreglo
        Figura[] figuras = new Figura[4];

        figuras[0] = c1;
        figuras[1] = circ1;
        figuras[2] = t1;
        figuras[3] = tr1;

        System.out.println("Figuras creadas: ");

        //Aqui ya no supe como imprimir, tendira que hacer un toString??
        for(Figura f: figuras){
            System.out.println();
        }
    }
}
