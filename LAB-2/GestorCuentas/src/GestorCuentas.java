import java.util.ArrayList;
import java.util.Iterator;

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
    public int eliminarCuentaPersona(int nroCuenta){
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

    public int eliminarCuentaSociedad(int nroCuenta){
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

    public void editarCuentaPersona(int numeroCuenta, double nuevoSaldo){
        try{
            for(CuentaPersona person : personas){
                if (person.numeroCuenta == numeroCuenta){
                    person.saldo = nuevoSaldo;
                    return;
                } else System.out.println("No existe una Persona con esa ID.");
            }
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

    public void mostrarTodasLasCuentas(){
        // MOSTRAR TODAS LAS PERSONAS
        System.out.println("Personas: \n  { \n");
        for (CuentaPersona person : personas){
            person.mostrarInfo();
            /*
            System.out.println("NroCuenta: " +person.numeroCuenta + ", Nombre: "
                    + person.getNombre()  + ", Apellido: " +person.getApellido() );
            */
        }
        System.out.println("  }");

        // MOSTRAR TODAS LAS SOCIEDADES
        System.out.println("Sociedades: \n  { \n");
        for (CuentaSociedad sociedad : sociedades){
            sociedad.mostrarInfo();
        }
        System.out.println("  }");
    }

}
