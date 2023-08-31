public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double pagoXhoras;

    public EmpleadoPorHoras(String nombre, int horasTrabajadas, double pagoXhoras){
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoXhoras = pagoXhoras;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas * pagoXhoras;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getPagoXhoras() {
        return pagoXhoras;
    }
}
