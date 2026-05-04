public abstract class Habitacion {
    // Encapsulamiento: Atributos privados
    private String codigo;
    private String tipoHabitacion;
    private double tarifaBase;
    private int numeroNoches;
    private boolean disponible;
    private String nombreHuesped;

    // Constructor
    public Habitacion(String codigo, String tipoHabitacion, double tarifaBase) {
        this.codigo = codigo;
        this.tipoHabitacion = tipoHabitacion;
        setTarifaBase(tarifaBase); // Validación en el constructor usando el setter
        this.disponible = true;
    }

    // Encapsulamiento: Getters y Setters con validaciones
    public void setTarifaBase(double tarifaBase) {
        if (tarifaBase > 0) {
            this.tarifaBase = tarifaBase;
        } else {
            System.out.println("Error: La tarifa debe ser un valor positivo.");
        }
    }

    public void setNumeroNoches(int numeroNoches) {
        if (numeroNoches > 0) {
            this.numeroNoches = numeroNoches;
        } else {
            System.out.println("Error: El número de noches debe ser mayor a cero.");
        }
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getTarifaBase() { return tarifaBase; }
    public int getNumeroNoches() { return numeroNoches; }
    public String getNombreHuesped() { return nombreHuesped; }
    public boolean isDisponible() { return disponible; }
    public String getTipoHabitacion() { return tipoHabitacion; }

    // Métodos Abstractos
    public abstract double calcularHospedaje();
    public abstract void mostrarDetalle();

    // Método Propio
    public boolean verificarDisponibilidad() {
        return this.disponible;
    }

    // Sobrecarga de métodos
    public double calcularPago(int noches) {
        return this.tarifaBase * noches;
    }

    public double calcularPago(int noches, double descuentoEspecial) {
        return (this.tarifaBase * noches) - descuentoEspecial;
    }
}




