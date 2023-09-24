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
        System.out.println("Coche [patente="+getPatente() +",marca="+this.getMarca() +
                ",modelo=" + this.getModelo()+ ",color=" +color + ",precio=$" + this.getPrecio() +"]");
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getPatente() {
        return super.getPatente();
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    @Override
    public String getMarca() {
        return super.getMarca();
    }

    @Override
    public String getModelo() {
        return super.getModelo();
    }

    @Override
    public void setMarca(String marca) {
        super.setMarca(marca);
    }

    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo);
    }

    @Override
    public void setPatente(String patente) {
        super.setPatente(patente);
    }

    @Override
    public void setPrecio(double precio) {
        super.setPrecio(precio);
    }

    public void setColor(String color) {
        this.color = color;
    }
}
