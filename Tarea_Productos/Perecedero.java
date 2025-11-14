public class Perecedero extends Producto {
    public int diasParaCaducar;

    public Perecedero(String nombre, double precio, int diasParaCaducar) {
        super(nombre, precio);
        this.diasParaCaducar = diasParaCaducar;
    }

    public String calcular() {
        // Reglas específicas solicitadas:
        // dias == 1 -> se cobra 1/4 del precio
        // dias == 2 -> se cobra 1/3 del precio
        // dias == 3 -> se cobra 1/2 del precio
        // si faltan más de 3 días -> va sin descuento
        if (diasParaCaducar <= 0) {
            return "Precio final: 0.0, Descuento: 100%"; // ya caducado
        } else if (diasParaCaducar == 1) {
            double precioFinal = precio * 0.25;
            return "Precio final: " + precioFinal + ", Descuento: " + 75 + "%";
        } else if (diasParaCaducar == 2) {
            double precioFinal = precio / 3.0; // 1/3 del precio
            return "Precio final: " + precioFinal + ", Descuento: " + (100 - (100.0 / 3.0)) + "%";
        } else if (diasParaCaducar == 3) {
            double precioFinal = precio * 0.5; // 1/2 del precio
            return "Precio final: " + precioFinal + ", Descuento: " + 50 + "%";
        } else {
            // más de 3 días...
            return "Precio final: " + precio + ", Descuento: 0%";
        }
    }
}
