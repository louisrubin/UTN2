import java.util.ArrayList;
import java.util.Iterator;

public class GestorCuentas {
    private ArrayList<CuentaPersona> personas = new ArrayList<CuentaPersona>();
    private ArrayList<CuentaSociedad> sociedades = new ArrayList<CuentaSociedad>();

    public GestorCuentas(){
        // ..
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
    public void eliminarCuentaPersona(int nroCuenta){
        try{
            for (CuentaPersona person : personas){
                if (nroCuenta == person.numeroCuenta) {
                    personas.remove(person);
                    return;
                } else {
                    System.out.println("No existe ese numero de cuenta.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar una persona. " + e.getMessage());
        }
    }

    public void eliminarCuentaSociedad(int nroCuenta){
        try{
            for (CuentaSociedad sociedad : sociedades){
                if (nroCuenta == sociedad.numeroCuenta) {
                    personas.remove(sociedad);
                    return;
                } else {
                    System.out.println("No existe ese numero de cuenta.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar una sociedad. " + e.getMessage());
        }
    }

}
