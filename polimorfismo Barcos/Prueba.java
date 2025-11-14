package polimorfismo;

public class Prueba {
    public static void main (String [] args){
        Barco[] barcos = new Barco[3];
        System.out.println("\n\n");
        DeVapor dv = new DeVapor();
        System.out.println("\n\n");
        Velero v = new Velero();
        System.out.println("\n\n");
        Carguero c = new Carguero();

        barcos[0]=dv;
        barcos[1]=v;
        barcos[2]=c;

        for(int i=0; i<3; i++){
            //barcos[i].alarma();

            if(barcos[i] instanceof DeVapor){
                System.out.println("En el indice: "+i+" Se encontro un barco de vapor\n");
                DeVapor x = (DeVapor) barcos[i];
                x.metodoDeVapor();
            }
            if(barcos[i] instanceof Velero){
                System.out.println("En el indice: "+i+" Se encontro un barco Velero\n");
                Velero y = (Velero) barcos[i];
                y.metodoVelero();
            }
            if(barcos[i] instanceof Carguero){
                System.out.println("En el indice: "+i+" Se encontro un barco Carguero\n");
                Carguero z = (Carguero) barcos[i];
                z.metodoCarguero();
            }
        }
    }
}
