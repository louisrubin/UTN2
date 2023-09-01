public class EmpleadoAsalariado extends Empleado implements Impuesto {

    public EmpleadoAsalariado(String nombre, double salario){
        super(nombre, salario);
    }

    @Override
    public double calcularSueldo() {
        return this.getSueldoBase();
    }

    @Override
    public double calcularImpuesto() {
        // devuelve solo la cantidad que se debe restar al sueldo
        return this.calcularSueldo() * 0.3;
    }
}
