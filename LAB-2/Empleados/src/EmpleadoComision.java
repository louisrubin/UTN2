public class EmpleadoComision extends Empleado implements Impuesto {
    private int ventasRealizadas;
    private double comisionXventas;
    private final double precioXventas = 100;

    public EmpleadoComision(String nombre){
        super(nombre);
    }

    public EmpleadoComision(String nombre, double sueldo, int ventasRealizadas, double comisionXventas){
        super(nombre, sueldo);
        this.ventasRealizadas = ventasRealizadas;
        this.comisionXventas = comisionXventas;
    }

    @Override
    public double calcularSueldo() {
        // sueldo base + ...
        return this.getSueldoBase() +
                (  (precioXventas * comisionXventas / 100)  * ventasRealizadas  ) ;
    }

    @Override
    public double calcularImpuesto() {
        // devuelve solo la cantidad que se debe restar al sueldo
        return this.calcularSueldo() * 0.2;
    }

    @Override
    public String toString() {
        return "[id="+ getId() + ",nombre=" + this.getNombre() + ",sueldo=$"+getSueldoBase()
                + ",ventasRealizadas=" + ventasRealizadas + ",comision=" + comisionXventas + "%,]";
    }
}
