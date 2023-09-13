public class CuentaPersona extends Cuenta{
    private String nombre, apellido;

    public CuentaPersona(){
        this.numeroCuenta = sigId++;
    }
    public CuentaPersona(String nom, String apell, double saldo){
        this.numeroCuenta = sigId++;
        this.nombre = nom;
        this.apellido = apell;
        this.saldo = saldo;
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
