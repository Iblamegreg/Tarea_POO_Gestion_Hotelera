public class Suite extends Habitacion {
    private boolean jacuzzi;
    private double servicioPremium;

    public Suite(String codigo, boolean jacuzzi) {
        super(codigo, "Suite", 80.0); // Tarifa base $80
        this.jacuzzi = jacuzzi;
        this.servicioPremium = 20.0;
    }

    @Override
    public double calcularHospedaje() {
        double subtotal = calcularPago(getNumeroNoches());
        double recargo = jacuzzi ? servicioPremium : 0;
        double descuento = getNumeroNoches() > 5 ? (subtotal * 0.10) : 0;
        double iva = (subtotal - descuento + recargo) * 0.15;
        return subtotal - descuento + recargo + iva;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("--- Factura de Suite ---");
        double subtotal = calcularPago(getNumeroNoches());
        double descuento = getNumeroNoches() > 5 ? (subtotal * 0.10) : 0;
        double recargo = jacuzzi ? servicioPremium : 0;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (> 5 noches): -$" + descuento);
        System.out.println("Recargo (Jacuzzi/Premium): +$" + recargo);
        System.out.println("IVA (15%): +$" + ((subtotal - descuento + recargo) * 0.15));
        System.out.println("Total a Pagar: $" + calcularHospedaje());
    }
}