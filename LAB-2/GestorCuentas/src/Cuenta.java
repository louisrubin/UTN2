public abstract class Cuenta {
    protected int numeroCuenta;
    protected double saldo;
    public static byte sigId = 0;

    public abstract void depositar(double cant);
    public abstract boolean retirar(double cant);
    public abstract void mostrarInfo();
}
