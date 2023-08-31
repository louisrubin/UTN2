public class Empleado {
    private String nombre;
    private int id;
    private double sueldoBase;

    private static byte siguienteID=0;

    public Empleado(String nombre){
        this.id = siguienteID++;
        this.nombre = nombre;
    }

    public Empleado(String nombre, double sueldo){
        this.id = siguienteID++;
        this.nombre= nombre;
        this.sueldoBase = sueldo;
    };

    public double calcularSueldo(){
        return sueldoBase;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
