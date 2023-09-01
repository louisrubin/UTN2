public abstract class Empleado {
    private String nombre;
    private int id;
    private double sueldoBase;

    private static byte siguienteID=0;

    protected Empleado(){
        // ..
    }
    protected Empleado(String nombre){
        this.id = siguienteID++;
        this.nombre = nombre;
    }

    protected Empleado(String nombre, double sueldo){
        this.id = siguienteID++;
        this.nombre= nombre;
        this.sueldoBase = sueldo;
    };

    protected abstract double calcularSueldo();

    protected double getSueldoBase() {
        return sueldoBase;
    }

    protected int getId() {
        return id;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
