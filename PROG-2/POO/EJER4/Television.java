package POO.EJER4;

public class Television extends Electrodomestico {
    private double resolucion;
    private boolean TDT;

    public Television(){
        // Por defecto, la resolución será de 20 pulgadas y el sintonizador será false.
        this.resolucion = 20;
        this.TDT = false;
    }
    public Television(double precio, double peso){
        // Un constructor con el precio y peso. El resto por defecto.
        this.precioBase = precio;
        this.peso = peso;
        this.resolucion = 20;
        this.TDT = false;
    }
    public Television(double resolucion, boolean tdt){
        // Un constructor con la resolución, sintonizador TDT y el resto de atributos heredados
        super();
        this.resolucion = resolucion;
        this.TDT = tdt;
    }

    public double getResolucion() {
        return resolucion;
    }
    public boolean getTDT() {
        return TDT;
    }

    @Override
    public double precioFinal() {
        /* si tiene una resolución mayor de 40 pulgadas, se incrementará el precio un
            30% y si tiene un sintonizador TDT incorporado, aumentará $50. Recuerden que las
            condiciones de la clase Electrodoméstico también deben afectar al precio  */

        double precioFinal = super.precioFinal();
        precioFinal = ( this.resolucion > 40 ) ? precioBase * 0.3 : precioFinal;
        precioFinal = ( this.TDT ) ? precioFinal + 50 : precioFinal;

        return precioFinal;
    }
    @Override
    public String toString() {
        return "[id=" + id + ",precioBase=$"+ precioBase + ",color="
                + color + ",consumo=" + consumoEnerg + ",peso=" + peso
                + ",precioFinal=$" + precioFinal() + "\n " +
                "resolucion=" + resolucion + "',TDT?=" + TDT + "]" ;
    }

    /*
    public static void main(String[] args) {
        Television t = new Television(999, 12);
        Television t2 = new Television(32, true);
        System.out.println(t.toString());
        System.out.println(t2.toString());
    }
    */
}
