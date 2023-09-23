public class CuentaSociedad extends Cuenta{
    private String nombreEmpresa, tipoEmpresa;

    public CuentaSociedad(){
        this.numeroCuenta = sigId++;
        System.out.println("Nueva Cuenta Sociedad (NumeroCuenta= "+numeroCuenta+")");
    }
    public CuentaSociedad(String nombreEmpresa, String tipoEmpresa){
        this.numeroCuenta = sigId++;
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
        System.out.println("Nueva Cuenta Sociedad (NumeroCuenta= "+numeroCuenta+")");
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
        System.out.println("[NroCuenta="+numeroCuenta +
                ",nombreEmpresa="+nombreEmpresa+",tipo="+tipoEmpresa+",saldo=$" +saldo
                );
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }
    public void setSueldo(double sueldo){
        this.saldo = sueldo;
    }
}
