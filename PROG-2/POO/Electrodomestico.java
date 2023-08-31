package POO;
public class Electrodomestico {
    protected byte id;
    protected double precioBase, peso;
    protected String color;
    protected char consumoEnerg;

    public static byte siguienteId=0;   /* al ser static no hace falta instanciar un objeto
                                        para que esta variable exista y se asigne un valor
                                                */
    private final String[] listaColores = {"blanco", "negro", "rojo",
                                    "azul", "gris"};
    private final char[] listConsumoEnerg = {'A', 'B', 'C', 'D', 'E', 'F'};

    public Electrodomestico(){
        this.id = siguienteId++;
        precioBase = 100.0;
        color = this.listaColores[0];
        consumoEnerg = this.listConsumoEnerg[5];
        peso = 5.0;
    }
    public Electrodomestico(double precioBase, double peso){
        this();
        this.precioBase = precioBase;
        this.peso = peso;
        color = this.listaColores[0];
        consumoEnerg = this.listConsumoEnerg[5];
    }
    public Electrodomestico(double precioBase, char consumoEnerg, double peso, String color){
        this();
        this.precioBase= precioBase;
        this.color = ( this.comprobarColor(color) ? color : this.listaColores[0] );
        this.consumoEnerg = ( this.comprobarConsumoEnergetico(consumoEnerg) ? Character.toUpperCase(consumoEnerg) : this.listConsumoEnerg[5] );
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public byte getId() {
        return id;
    }

    public String getColor() {
        return color.toUpperCase();
    }

    public char getConsumoEnerg() {
        return consumoEnerg;    // no hace falta hacerlo mayuscula porque la funcion "comprobar" define en mayus
    }

    public char[] getListConsumoEnerg() {
        return listConsumoEnerg;
    }

    public String[] getListaColores() {
        return listaColores;
    }

    public double getPeso() {
        return peso;
    }
    public boolean comprobarConsumoEnergetico(char letra){
        // solo comprueba que sea una letra permitida, devuelve true o false
        boolean ret = false;
        for(int a=0; a < this.listConsumoEnerg.length; a++){
            if(Character.toUpperCase(letra) == this.listConsumoEnerg[a]){
                ret = true;
                break;
            }
        }
        return ret;
    }
    public boolean comprobarColor(String color){
        // solo comprueba que sea un color permitido, devuelve true o false
        boolean ret = false;
        for(int a=0; a < this.listaColores.length; a++){
            if(color.toLowerCase().equals(this.listaColores[a]) ){
                ret = true;
                break;
            }
        }
        return ret;
    }
    public double precioFinal(){
        // según el consumo energético, aumentara su precio, y según su tamaño, también
        // si encuentra la letra devuelve la posicion SIGUIENTE convertido a entero
        String[] letraPrecio = {"A", "100", "B", "80", "C", "60", "D", "50",
                                "E", "30", "F", "10"};
        double precioFinal = this.precioBase;

        for (int x = 0; x < letraPrecio.length; x++){
            if (Character.toString(this.consumoEnerg).equals( letraPrecio[x] ) ){
                precioFinal += Integer.parseInt(letraPrecio[x+1]);
                // parsea a entero la posicion siguiente donde está la LETRA
                break;
            }
        }

        if(this.peso >= 0 && this.peso <= 19){
            precioFinal += 10;
        } else if (this.peso >= 20 && this.peso <= 49){
            precioFinal += 50;
        } else if (this.peso >= 50 && this.peso <= 79){
            precioFinal += 80;
        } else if (this.peso >= 80 && this.peso <= 100){
            precioFinal += 100;
        }

        System.out.println(this.precioBase + " + " + (precioFinal - this.precioBase) );
        return precioFinal;
    }

    @Override
    public String toString() {
        return "[id=" + this.id +  ",precioBase=$"+this.precioBase + ",color="
                + this.color+",consumo=" + this.consumoEnerg + ",peso=" + this.peso + "]" ;
    }
}
