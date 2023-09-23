package EjemParcial1;

public class Coche extends Vehiculo{

    private String color;
    public Coche(){
        super();
        System.out.println("Nuevo Coche [patente "+this.getPatente() +"]");
    }
    public Coche(String color){
        super();
        this.color = color;
        System.out.println("Nuevo Coche [patente "+this.getPatente() +"]");
    }
    @Override
    public double calcularImpuesto() {
        // impuesto del 15%
        return this.getPrecio() * 0.85;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("[patente="+getPatente() +",marca="+this.getMarca()+",modelo="+this.getModelo()+ ",color=" +color +"]");
    }
}
