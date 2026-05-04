import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Habitacion habitacionReservada = null; // Referencia polimórfica

        System.out.println("=== SISTEMA DE RESERVAS HOTEL ===");
        System.out.print("Ingrese nombre del huésped: ");
        String nombre = scanner.nextLine();

        System.out.println("Seleccione el tipo de habitación:");
        System.out.println("1. Simple ($35/noche)\n2. Suite ($80/noche)\n3. Familiar ($60/noche)");
        int tipo = scanner.nextInt();

        System.out.print("Ingrese el número de noches: ");
        int noches = scanner.nextInt();

        // Procesamiento Polimórfico
        switch (tipo) {
            case 1:
                System.out.print("¿Desea desayuno incluido? (true/false): ");
                boolean desayuno = scanner.nextBoolean();
                habitacionReservada = new HabitacionSimple("HS-101", desayuno);
                break;
            case 2:
                System.out.print("¿Desea activar el jacuzzi? (true/false): ");
                boolean jacuzzi = scanner.nextBoolean();
                habitacionReservada = new Suite("ST-201", jacuzzi);
                break;
            case 3:
                habitacionReservada = new HabitacionFamiliar("HF-301");
                System.out.print("Ingrese cantidad de personas: ");
                int personas = scanner.nextInt();
                ((HabitacionFamiliar) habitacionReservada).setCapacidadPersonas(personas);
                break;
            default:
                System.out.println("Opción no válida.");
                System.exit(0);
        }

        // Setear valores mediante encapsulamiento
        habitacionReservada.setNombreHuesped(nombre);
        habitacionReservada.setNumeroNoches(noches);
        habitacionReservada.setDisponible(false); // Cambiamos el estado de disponibilidad

        // Simulación de factura final
        System.out.println("\n==================================");
        System.out.println("       RESUMEN DE LA RESERVA      ");
        System.out.println("==================================");
        System.out.println("Huésped: " + habitacionReservada.getNombreHuesped());
        System.out.println("Habitación: " + habitacionReservada.getTipoHabitacion());
        System.out.println("Tarifa Base: $" + habitacionReservada.getTarifaBase());
        System.out.println("Noches: " + habitacionReservada.getNumeroNoches());

        if (!habitacionReservada.verificarDisponibilidad()) {
            System.out.println("Estado: Confirmada (No Disponible)");
        }

        System.out.println("----------------------------------");
        habitacionReservada.mostrarDetalle(); // Ejecuta el método sobreescrito según la clase hija
        System.out.println("==================================");

        scanner.close();
    }
}