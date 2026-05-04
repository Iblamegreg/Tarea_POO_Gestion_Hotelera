public class HabitacionSimple extends Habitacion {
    private boolean desayunoIncluido;
    private double costoServicioBasico;

    public HabitacionSimple(String codigo, boolean desayunoIncluido) {
        super(codigo, "Simple", 35.0); // Tarifa base $35
        this.desayunoIncluido = desayunoIncluido;
        this.costoServicioBasico = 5.0;
    }

    @Override
    public double calcularHospedaje() {
        double subtotal = calcularPago(getNumeroNoches()); // Uso de método sobrecargado
        double recargo = desayunoIncluido ? (costoServicioBasico * getNumeroNoches()) : 0;
        double descuento = getNumeroNoches() > 5 ? (subtotal * 0.10) : 0; // 10% si > 5 noches
        double iva = (subtotal - descuento + recargo) * 0.15; // IVA 15%
        return subtotal - descuento + recargo + iva;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("--- Factura de Habitación Simple ---");
        double subtotal = calcularPago(getNumeroNoches());
        double descuento = getNumeroNoches() > 5 ? (subtotal * 0.10) : 0;
        double recargo = desayunoIncluido ? (costoServicioBasico * getNumeroNoches()) : 0;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (> 5 noches): -$" + descuento);
        System.out.println("Recargo (Desayuno): +$" + recargo);
        System.out.println("IVA (15%): +$" + ((subtotal - descuento + recargo) * 0.15));
        System.out.println("Total a Pagar: $" + calcularHospedaje());
    }
}