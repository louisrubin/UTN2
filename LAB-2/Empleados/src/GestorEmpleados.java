import java.util.ArrayList;
import java.util.Iterator;

public class GestorEmpleados {
    private ArrayList<Empleado> empleados;

    public GestorEmpleados(){
        empleados = new ArrayList<Empleado>();
    }

    public void addEmpleado(Empleado empleadoParam) {
        // metodo para agregar un empleado al array.
        if ( ! empleadoRepetido(empleadoParam) ) {
            // si NO es repetido continua:
            empleados.add(empleadoParam);
            System.out.println("Empleado agregado.");
            return;
        }
        System.out.println("Empleado NO agregado.");
    }
    public void removeEmpleado(int id) {    // Metodo que elimina un empleado del array, usa un for loop para encontrar
                                            // la ID a remover, y se rompe para salir del loop.
        for ( Empleado EMPLEADO : empleados) {
            // variable de tipo Empleado recorre el array de tipo Empleado
            if (EMPLEADO.getId() == id) {
                empleados.remove(EMPLEADO);
                System.out.println("Empleado eliminado.");
                return;
            }
        }
    }

    @Override
    public boolean equals(Object objParam) {
        Empleado E = (Empleado) objParam;
        return false;
    }

    public void removeAllEmpleados(){
        Iterator<Empleado> iterator = empleados.iterator();
        while (iterator.hasNext()){
            // mientras haya un elemento siguiente
            iterator.remove();
            //iterator = empleados.iterator();    // reinicia el conteo del iterator (vuelve a la posicion 0)
        }
        System.out.println("Eliminados todos.");
    }
    public boolean empleadoRepetido(Empleado empleadoParam){
        // devuelve true si son repetidos
        for (Empleado EMPLEADO : empleados){
            // mientras haya un elemento siguiente
            return (EMPLEADO.getId() == empleadoParam.getId());
        }
        return false;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    @Override
    public String toString() {
        for (Empleado EMPLEADO : empleados){
            System.out.println(EMPLEADO.getId() + ", "+EMPLEADO.getNombre()
                    + ", $"+ EMPLEADO.getSueldoBase() +" -> $" + EMPLEADO.sueldoFinal() );
        }
        return "QQQQ";
    }

    /*
            if(iterator.getId() == 1 ){
                iterator.remove();
                break;
            }
            SETList no permite elementos repetidos (arroja un error)
        */
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        EmpleadoAsalariado e = new EmpleadoAsalariado("luis", 1500);
        EmpleadoPorHoras e2 = new EmpleadoPorHoras("pepe", 6, 15);
        EmpleadoComision e3 = new EmpleadoComision("jose", 1300, 5, 15);

        gestor.toString();
        gestor.addEmpleado(e);
        gestor.addEmpleado(e2);
        gestor.addEmpleado(e3);
        gestor.addEmpleado( new EmpleadoAsalariado("sofia", 1300) );
        gestor.toString();
    }
}
