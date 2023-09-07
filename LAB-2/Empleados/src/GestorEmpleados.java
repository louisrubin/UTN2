import java.util.ArrayList;
import java.util.Scanner;

public class GestorEmpleados {
    private ArrayList<Empleado> empleados;

    public GestorEmpleados(){
        empleados = new ArrayList<Empleado>();
    }

    public void addEmpleado(Empleado empleadoParam) {
        // metodo para agregar un empleado al array.
        if ( ! empleadoRepetido(empleadoParam) ) {
            // si NO es repetido continua:
            this.empleados.add(empleadoParam);
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
    public void editEmpleado(int id){
        Scanner sc = new Scanner(System.in);
        for (Empleado EMPLEADO : empleados){

            if (EMPLEADO.getId() == id){
                System.out.print("(X para omitir) NOMBRE '"+EMPLEADO.getNombre() +"'  -->  ");
                String Nnombre = sc.nextLine();

                if ( ! Nnombre.equalsIgnoreCase("x") ) {
                    EMPLEADO.setNombre(Nnombre);
                }
                if ( ! (EMPLEADO instanceof EmpleadoPorHoras) ){
                    System.out.print("SUELDO BASE $"+EMPLEADO.getSueldoBase() +"'  -->  $");
                    EMPLEADO.setSueldoBase(sc.nextDouble());
                }
                System.out.println();
                return;
            }
        }
        sc.close();
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
        for (Empleado EMPLEADO : this.empleados){
            System.out.println(EMPLEADO.getId() + ", "+EMPLEADO.getNombre()
                    + ", $"+ EMPLEADO.getSueldoBase() +" -> $" + EMPLEADO.sueldoFinal() );
        }
        return "public String toString() { }";
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

        gestor.addEmpleado(e);
        gestor.addEmpleado(e2);
        gestor.addEmpleado(e3);
        gestor.toString();
        gestor.addEmpleado( new EmpleadoAsalariado("sofia", 1300) );
        gestor.editEmpleado(0);
        gestor.toString();
    }
}
