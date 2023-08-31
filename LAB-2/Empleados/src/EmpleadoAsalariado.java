public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(String nombre, double salario){
        super(nombre, salario);
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo();
    }
}
