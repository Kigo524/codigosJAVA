import java.time.LocalDate;

public class NoPerecedero extends Producto {
    public int anioElaboracion;
    public static final int ANIO_ACTUAL = LocalDate.now().getYear();

    public NoPerecedero(String nombre, double precio, int anioElaboracion) {
        super(nombre, precio);
        this.anioElaboracion = anioElaboracion;
    }

    public String calcular() {
        int edad = ANIO_ACTUAL - anioElaboracion;
        if (edad < 0) {
            // anio invalido: devolver precio sin descuento
            return "Precio final: " + precio + ", Descuento: 0%";
        }

        if (edad < 10) {
            return "Precio final: " + precio + ", Descuento: 0%"; // precio normal
        } else {
            double descuento = 0.2; // 20%
            double precioFinal = precio * (1 - descuento);
            return "Precio final: " + precioFinal + ", Descuento: " + (descuento * 100) + "%";
        }
    }
}
