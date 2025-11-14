public class PruebaProductos {
    public static void main(String[] args) {

        Producto[] lista = new Producto[6];

        // 3 perecederos
        lista[0] = new Perecedero("Leche", 30.0, 2);
        lista[1] = new Perecedero("Yogurt", 25.0, 1);
        lista[2] = new Perecedero("Queso", 120.0, 5);

        // 3 no perecederos
        lista[3] = new NoPerecedero("Juguete", 150.0, 2010);
        lista[4] = new NoPerecedero("Mueble", 2000.0, 2020);
        lista[5] = new NoPerecedero("Electrodoméstico", 3500.0, 2005);

        int total = 0;
        int i = 0;
        while (i < lista.length) {
            Producto prod = lista[i];
            total++;
            System.out.println("-----");
            System.out.println("Nombre: " + prod.nombre);
            System.out.println("Precio: " + prod.precio);
            if (prod instanceof Perecedero) {
                Perecedero pe = (Perecedero) prod;
                System.out.println("Días para caducar: " + pe.diasParaCaducar);
                System.out.println(pe.calcular());
            } else if (prod instanceof NoPerecedero) {
                NoPerecedero np = (NoPerecedero) prod;
                System.out.println("Año de elaboración: " + np.anioElaboracion);
                System.out.println(np.calcular());
            }
            i++;
        }

        System.out.println("-----");
        System.out.println("Cantidad total de productos: " + total);
    }
}
