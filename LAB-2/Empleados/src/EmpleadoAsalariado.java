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
        return this.getSueldoBase() * 0.3;
    }
    @Override
    public double sueldoFinal() {
        return getSueldoBase() - calcularImpuesto();
    }
    /*
    @Override
    public boolean equals(Object obj) {
        // equals por defecto compara el hash (id) del objeto son iguales
        // ahora lo sobreescribo y comparo los ID de los objetos
        if ( obj instanceof EmpleadoAsalariado){
            EmpleadoAsalariado Param = (EmpleadoAsalariado) obj;
            return this.getId() == Param.getId();
        }
        return false;
    }

     */
}
