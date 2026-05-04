public class HabitacionFamiliar extends Habitacion {
    private int capacidadPersonas;
    private double descuentoFamiliar;

    public HabitacionFamiliar(String codigo) {
        super(codigo, "Familiar", 60.0); // Tarifa base $60
        this.descuentoFamiliar = 0.05; // 5% extra cliente frecuente/familiar
    }

    public void setCapacidadPersonas(int capacidad) {
        if (capacidad > 0 && capacidad <= 6) {
            this.capacidadPersonas = capacidad;
        } else {
            System.out.println("Error: La capacidad debe ser entre 1 y 6 personas.");
        }
    }

    @Override
    public double calcularHospedaje() {
        double subtotal = calcularPago(getNumeroNoches());
        double descuento = getNumeroNoches() > 5 ? (subtotal * 0.10) : 0;
        descuento += (subtotal * descuentoFamiliar);
        double iva = (subtotal - descuento) * 0.15;
        return subtotal - descuento + iva;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("--- Factura de Habitación Familiar ---");
        double subtotal = calcularPago(getNumeroNoches());
        double descuentoNoches = getNumeroNoches() > 5 ? (subtotal * 0.10) : 0;
        double descuentoFam = subtotal * descuentoFamiliar;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento Total: -$" + (descuentoNoches + descuentoFam));
        System.out.println("IVA (15%): +$" + ((subtotal - (descuentoNoches + descuentoFam)) * 0.15));
        System.out.println("Total a Pagar: $" + calcularHospedaje());
    }
}