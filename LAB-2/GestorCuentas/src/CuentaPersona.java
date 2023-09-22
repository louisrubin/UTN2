public class CuentaPersona extends Cuenta{
    private String nombre, apellido;

    public CuentaPersona(){
        this.numeroCuenta = sigId++;
        System.out.println("Nueva Cuenta Persona (NumeroCuenta= "+numeroCuenta+")");
    }
    public CuentaPersona(String nombre, String apellido){
        this.numeroCuenta = sigId++;
        this.nombre = nombre;
        this.apellido = apellido;
        System.out.println("Nueva Cuenta Persona (NumeroCuenta= "+numeroCuenta+")");
    }
    public CuentaPersona(String nombre, String apell, double saldo){
        this.numeroCuenta = sigId++;
        this.nombre = nombre;
        this.apellido = apell;
        this.saldo = saldo;
        System.out.println("Nueva Cuenta Persona (NumeroCuenta= "+numeroCuenta+")");
    }

    @Override
    public void depositar(double cant) {
        this.saldo += cant;
    }

    @Override
    public boolean retirar(double cant) {
        if (cant <= this.saldo){
            this.saldo -= cant;
            return true;    /* operacion exitosa */
        }
        return false;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("[NroCuenta="+numeroCuenta+",nombre="+nombre+",apellido="+apellido+",saldo=$"+saldo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
