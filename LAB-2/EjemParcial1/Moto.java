package EjemParcial1;

public class Moto extends Vehiculo{
    private int cilindrada;

    public Moto(){
        super();
        System.out.println("Nueva Moto [patente "+this.getPatente() +"]");
    }
    public Moto(int cilindrada){
        super();
        this.cilindrada = cilindrada;
        System.out.println("Nueva Moto [patente "+this.getPatente() +"]");
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
        Moto m1 = new Moto(110);
        Moto m2 = new Moto(260);
        Moto m3 = new Moto(150);
        Moto m4 = new Moto();
        Moto m5 = new Moto();

        Coche c1 = new Coche();
        Coche c2 = new Coche("negro");

        System.out.println(m1.getPatentesRegistradas());

        m1.mostrarInformacion();
        m2.mostrarInformacion();
        m3.mostrarInformacion();
        m4.mostrarInformacion();
        m5.mostrarInformacion();

        c1.mostrarInformacion();
        c2.mostrarInformacion();

    }
}
