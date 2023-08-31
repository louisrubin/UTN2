package POO.EJER4;

class Lavarropas extends Electrodomestico {
    private double carga = 5;

    public Lavarropas(){
        super();    // llama al contructor por defecto del padre
    }
    public Lavarropas(double precio, double peso){
        super(precio, peso);    // constructor del padre con esos parametros
    }

    public Lavarropas(double carga){
        super();    // llama al contructor por defecto del padre
        this.carga = carga;
    }
    public Lavarropas(double carga, double precioBase, double peso, char consumoEnerg, String color){
        super(precioBase, consumoEnerg, peso, color);    // llama al contructor con todos esos parametros
        this.carga = carga;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ",carga=" + this.carga + ",precioBase=$"+this.precioBase + ",color="
                + this.color+",consumo=" + this.consumoEnerg + ",peso=" + this.peso
                + ",precioFinal=$" + this.precioFinal() + "]" ;
    }

    public double getCarga() {
        return this.carga;
    }

    @Override
    public double precioFinal() {
        // si tiene una carga mayor de 30 kg, aumentará el precio $50 , sino es así, queda el mismo precio
        if(this.carga > 30){
            System.out.print(50.0 + " + ");
            return super.precioFinal() + 50;
        }
        else{
            return super.precioFinal();
        }
    }
/*
    public static void main(String[] args) {
        Lavarropas a = new Lavarropas(20, 350, 15 , 'e', "rojo");
        Lavarropas a2 = new Lavarropas();
        Lavarropas a3 = new Lavarropas(400, 12.5);

        System.out.println(a.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
    }
*/
}
