import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class GestorCuentas {
    private ArrayList<CuentaPersona> personas;
    private ArrayList<CuentaSociedad> sociedades;

    public GestorCuentas(){
        // CONSTRUCTOR POR DEFECTO INSTANCIA LOS ARRAY LIST
        personas = new ArrayList<CuentaPersona>();
        sociedades = new ArrayList<CuentaSociedad>();
    }

    public void agregarCuentaPersona(CuentaPersona personParam){
        try{
            personas.add(personParam);
        }catch (Exception e){
            System.out.println("Error al agregar una persona. " + e.getMessage());
        }
    }
    public void agregarCuentaSociedad(CuentaSociedad sociedadParam){
        try{
            sociedades.add(sociedadParam);
        } catch (Exception e) {
            System.out.println("Error al agregar una sociedad. " + e.getMessage());
        }
    }

    public void eliminarUnaCuenta(int nroCuenta){
        // METODO QUE USA LOS DOS METODOS ELIMINACION, ya que el nroCuenta aumenta independientemente de que cuenta sea
        if (nroCuenta > Cuenta.sigId || nroCuenta < 0){
            // como el Cuenta.sigId aumenta automaticamete, verifica que el nroCuenta ingresado no sea fuera de ese rango
            System.out.println("No existe ese numero de cuenta.");
            return;
        }
        if (eliminarCuentaPersona(nroCuenta) == 0 || eliminarCuentaSociedad(nroCuenta) == 0){
            System.out.println("Cuenta eliminada con exito.");
        }
    }
    private int eliminarCuentaPersona(int nroCuenta){
        try{
            for (CuentaPersona person : personas){
                if (nroCuenta == person.numeroCuenta) {
                    personas.remove(person);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar una cuenta. " + e.getMessage());
        }
        return 1;
    }

    private int eliminarCuentaSociedad(int nroCuenta){
        try{
            for (CuentaSociedad sociedad : sociedades){
                if (nroCuenta == sociedad.numeroCuenta) {
                    personas.remove(sociedad);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar una cuenta. " + e.getMessage());
        }
        return 1;
    }

    public void editarUnaCuenta(int nroCuenta, Scanner sc) {
        // METODO QUE USA LOS DOS METODOS EDITAR
        double nuevoSueldo = 0;

        for (CuentaPersona persona : personas){
            if (persona.numeroCuenta == nroCuenta) {

                try {
                    System.out.print("Ingrese nuevo sueldo: $");
                    nuevoSueldo = sc.nextDouble();
                }catch (Exception e){
                    System.out.println("ERROR: TIPO DE DATO INCORRECTO.");
                    sc.nextLine();
                    return;
                }

                persona.setSueldo(nuevoSueldo);
                System.out.println("Cuenta editado con exito.");
                return;
            }
        }
        // el for anterior tiene un 'return', si no se encontró una persona continua con este 'for'
        for (CuentaSociedad sociedad : sociedades){
            if (sociedad.numeroCuenta == nroCuenta) {

                try {
                    System.out.print("Ingrese nuevo sueldo: $");
                    nuevoSueldo = sc.nextDouble();
                }catch (Exception e){
                    System.out.println("ERROR: TIPO DE DATO INCORRECTO.");
                    sc.nextLine();
                    return;
                }

                sociedad.setSueldo(nuevoSueldo);
                System.out.println("Cuenta editado con exito.");
                return;
            }
        }
        // si ningun for encontró una cuenta significa que no se ejecutaron los 'returns'
        System.out.println("No existe ese numero de cuenta.");
    }

    public void mostrarTodasLasCuentas(){
        // MOSTRAR TODAS LAS PERSONAS
        System.out.print("PERSONAS: \n  { \n");
        for (CuentaPersona person : personas){
            System.out.print("\t");
            person.mostrarInfo();
        }
        System.out.println("  }");

        // MOSTRAR TODAS LAS SOCIEDADES
        System.out.print("SOCIEDADES: \n  { \n");
        for (CuentaSociedad sociedad : sociedades){
            System.out.print("\t");
            sociedad.mostrarInfo();
        }
        System.out.println("  }");
    }

    public ArrayList<CuentaPersona> getPersonas() {
        return personas;
    }

    public ArrayList<CuentaSociedad> getSociedades() {
        return sociedades;
    }
}
