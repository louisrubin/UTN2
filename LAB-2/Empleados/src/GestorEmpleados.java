import java.util.ArrayList;

public class GestorEmpleados {
    ArrayList<Empleado> empleados;

    public GestorEmpleados(){
        empleados = new ArrayList<Empleado>();
    }

    public void addEmpleado(Empleado empleado) {
        // metodo para agregar un empleado al array.
        empleados.add(empleado);
    }
    public void removeEmpleado(int id) {    // Metodo que elimina un empleado del array, usa un for loop para encontrar
                                            // la ID a remover, y se rompe para salir del loop.
        for ( Empleado EMPLEADO : empleados) {
            // variable de tipo Empleado recorre el array de tipo Empleado
            if (EMPLEADO.getId() == id) {
                empleados.remove(EMPLEADO);
                break;
            }
        }
    }
    //public void editEmpleado(String nombre, )

}
