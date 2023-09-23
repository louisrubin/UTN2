package EjemParcial1;

public class Moto extends Vehiculo{
    private int cilindrada;

    public Moto(){
        super();
    }
    public Moto(int cilindrada){
        super();
        this.cilindrada = cilindrada;
    }
    @Override
    public double calcularImpuesto() {
        // impuesto del 9%
        return this.getPrecio() * 0.91;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("[patente="+getPatente() +",marca="+this.getMarca()+",modelo="+this.getModelo()+",cilindrada="+this.cilindrada+"]");
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public static void main(String[] args) {
        Moto m1 = new Moto();
        Moto m2 = new Moto();
        Moto m3 = new Moto();
        Moto m4 = new Moto();
        Moto m5 = new Moto();

        System.out.println(m1.getPatentesRegistradas());

        m1.mostrarInformacion();
        m2.mostrarInformacion();
        m3.mostrarInformacion();
        m4.mostrarInformacion();
        m5.mostrarInformacion();

    }
}
