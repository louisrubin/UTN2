package EjemParcial1;

public class Coche extends Vehiculo{

    private String color;
    public Coche(){
        super();
    }
    public Coche(String color){
        super();
        this.color = color;
    }
    @Override
    public double calcularImpuesto() {
        // impuesto del 15%
        return this.getPrecio() * 0.85;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("[marca="+this.getMarca()+",modelo="+this.getModelo()+ ",color=" +color +"]");
    }
}
