public class PastelMaestraBetzaAnimado {

    public static void main(String[] args) throws InterruptedException {

        String[] flama1 = {
                "                                  ^  ^  ^",
                "                                  |  |  |"
        };

        String[] flama2 = {
                "                                   *  *  *",
                "                                   |  |  |"
        };

        while (true) {

            limpiarPantalla();
            imprimirPastel(flama1);
            Thread.sleep(500);

            limpiarPantalla();
            imprimirPastel(flama2);
            Thread.sleep(500);
        }
    }

    public static void imprimirPastel(String[] flama) {

        System.out.println("                🎉🎉🎉 FELICIDADES 🎉🎉🎉");
        System.out.println();
        System.out.println(flama[0]);
        System.out.println(flama[1]);
        System.out.println("                                __|__|__|__");
        System.out.println("                   .-\":::::::::::::::::::::::::::\"-.");
        System.out.println("                .-\"::::::::::::::::::::::::::::::::::\"-.");
        System.out.println("             .-\"::::::::::::::::::::::::::::::::::::::::::\"-.");
        System.out.println("           .\"::::::::::::::::::::::::::::::::::::::::::::::::::\".");
        System.out.println("         /::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\");
        System.out.println("        |                                                          |");
        System.out.println("        |                    MAESTRA  BETZA                       |");
        System.out.println("        |                                                          |");
        System.out.println("        |            ¡GRACIAS POR TODO SU APOYO!                   |");
        System.out.println("        |            ¡FELIZ DIA Y MUCHOS LOGROS!                   |");
        System.out.println("        |                                                          |");
        System.out.println("        |::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
        System.out.println("        |##########################################################|");
        System.out.println("        |##########################################################|");
        System.out.println("        |##########################################################|");
        System.out.println("        |##########################################################|");
        System.out.println("        |##########################################################|");
        System.out.println("        '----------------------------------------------------------'");
        System.out.println();
        System.out.println("                    🎂🎂🎂🎂🎂🎂🎂🎂🎂🎂");
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
