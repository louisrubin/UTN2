package POO;

class Lavarropas extends Electrodomestico {
    private double carga = 5;

    public Lavarropas(){
    }
    public Lavarropas(double precio, double peso){
        this.precioBase = precio;
        this.peso = peso;
    }

    public Lavarropas(double carga){
        this.id = super.id;
        this.carga = carga;
        this.precioBase = super.precioBase;
        this.consumoEnerg = super.consumoEnerg;
        this.peso = super.peso;
        this.color = super.color;
    }
    public Lavarropas(double carga, double precioBase, char consumoEnerg, String color){
        this.id = super.id;
        this.carga = carga;
        this.precioBase = precioBase;
        this.consumoEnerg = ( super.comprobarConsumoEnergetico(consumoEnerg)) ? Character.toUpperCase(consumoEnerg) : super.getListConsumoEnerg()[5] ;
        this.peso = super.peso;
        this.color = (super.comprobarColor(color)) ? color : super.getListaColores()[0];
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ",carga=" + this.carga + ",precioBase=$"+this.precioBase + ",color="
                + this.color+",consumo=" + this.consumoEnerg + ",peso=" + this.peso
                + ",precioFinal=$" + this.precioFinal() + "]" ;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        if(this.carga > 30){
            System.out.print(50.0 + " + ");
            return super.precioFinal() + 50;
        }
        else{
            return super.precioFinal();
        }
    }

    public static void main(String[] args) {
        Lavarropas a = new Lavarropas(20, 350, 'e', "rojo");
        Lavarropas a2 = new Lavarropas(50);
        System.out.println(a.toString());
        System.out.println(a2.toString());
    }
    // hacer que la asignacion de consumo se ponga en mayuscula ya en la clase PADRE
}
