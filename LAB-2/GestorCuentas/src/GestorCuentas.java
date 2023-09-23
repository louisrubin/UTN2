import java.util.ArrayList;
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

    public void editarUnaCuenta(int nroCuenta){
        // METODO QUE USA LOS DOS METODOS EDITAR
        Scanner sc = new Scanner(System.in);

        for (CuentaPersona persona : personas){
            if (persona.numeroCuenta == nroCuenta) {

                System.out.println("Ingrese nuevo sueldo: $");
                double nuevoSueldo = sc.nextDouble();
                persona.setSueldo(nuevoSueldo);
                System.out.println("Cuenta editado con exito.");
                sc.close();
                return;
            }
        }
        // el for anterior tiene un 'return', si no se encontró una persona continua con este 'for'
        for (CuentaSociedad sociedad : sociedades){
            if (sociedad.numeroCuenta == nroCuenta) {

                System.out.println("Ingrese nuevo sueldo: $");
                double nuevoSueldo = sc.nextDouble();
                sociedad.setSueldo(nuevoSueldo);
                System.out.println("Cuenta editado con exito.");
                sc.close();
                return;
            }
        }
        // si ningun for encontró una cuenta significa que no se ejecutaron los 'returns'
        System.out.println("No existe una cuenta con ese Nro de Cuenta.");
        sc.close();
    }

    /*
    public void editarCuentaPersona(CuentaPersona cuentaPersona, double nuevoSueldo){
        try{
            cuentaPersona.setSueldo(nuevoSueldo);
        }
        catch (Exception e){
            System.out.println("Error al editar una persona. " + e.getMessage());
        }
    }

    public void editarCuentaSociedad(int numeroCuenta, double nuevoSaldo){
        try{
            for(CuentaSociedad sociedad : sociedades){
                if (sociedad.numeroCuenta == numeroCuenta){
                    sociedad.saldo = nuevoSaldo;
                    return;
                } else System.out.println("No existe una Sociedad con esa ID.");
            }
        }
        catch (Exception e){
            System.out.println("Error al editar una sociedad. " + e.getMessage());
        }
    }
    */

    public void mostrarTodasLasCuentas(){
        // MOSTRAR TODAS LAS PERSONAS
        System.out.print("PERSONAS: \n  { \n");
        for (CuentaPersona person : personas){
            person.mostrarInfo();
        }
        System.out.println("  }");

        // MOSTRAR TODAS LAS SOCIEDADES
        System.out.print("SOCIEDADES: \n  { \n");
        for (CuentaSociedad sociedad : sociedades){
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
