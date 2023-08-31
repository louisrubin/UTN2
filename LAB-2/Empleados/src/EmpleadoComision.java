public class EmpleadoComision extends Empleado {
    private int ventasRealizadas;
    private double comisionXventas;
    private final double precioXventas = 100;

    public EmpleadoComision(String nombre, double sueldo, int ventasRealizadas, double comisionXventas){
        super(nombre, sueldo);
        this.ventasRealizadas = ventasRealizadas;
        this.comisionXventas = comisionXventas;
    }

    @Override
    public double calcularSueldo() {
        // sueldo base + ...
        return super.calcularSueldo()
                    +
                (  (precioXventas * comisionXventas / 100)  * ventasRealizadas  ) ;
    }

    @Override
    public String toString() {
        return "[id="+ getId() + ",nombre=" + this.getNombre() + ",sueldo=$"+getSueldoBase()
                + ",ventasRealizadas=" + ventasRealizadas + ",comision=" + comisionXventas + "%,]";
    }

    public static void main(String[] args) {
        EmpleadoComision a = new EmpleadoComision("pepe", 1500, 6, 12);
        EmpleadoComision a2 = new EmpleadoComision("jose", 500, 2, 15);
        System.out.println(a.toString());
        a.setNombre("luis");
        System.out.println(a.toString());
        System.out.println(a2.toString());
    }
}
