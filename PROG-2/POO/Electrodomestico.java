package POO;
public class Electrodomestico {
    private double precioBase, peso;
    private String color;
    private char consumoEnerg;

    private String[] listaColores = {"blanco", "negro", "rojo",
                                    "azul", "gris"};
    public char[] listConsumoEnerg = {'A', 'B', 'C', 'D', 'E', 'F'};

    public Electrodomestico(){
        precioBase = 100.0;
        color = listaColores[0];
        consumoEnerg = listConsumoEnerg[5];
        peso = 5.0;
    }
    public Electrodomestico(double precioBase, double peso){
        this.precioBase = precioBase;
        this.peso = peso;
        color = listaColores[0];
        consumoEnerg = listConsumoEnerg[5];
    }
    public Electrodomestico(double precioBase, String color, char consumoEnerg, double peso){
        this.precioBase= precioBase;
        this.color = ( comprobarColor(color) ? color : listaColores[0] );
        this.consumoEnerg = ( comprobarConsumoEnergetico(consumoEnerg) ? Character.toUpperCase(consumoEnerg) : listConsumoEnerg[5] );
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color.toUpperCase();
    }

    public char getConsumoEnerg() {
        return consumoEnerg;    // no hace falta hacerlo mayuscula porque la funcion "comprobar" define en mayus
    }

    public double getPeso() {
        return peso;
    }
    public boolean comprobarConsumoEnergetico(char letra){
        // solo comprueba que sea una letra permitida, devuelve true o false
        boolean ret = false;
        for(int a=0; a < listConsumoEnerg.length; a++){
            if(Character.toUpperCase(letra) == listConsumoEnerg[a]){
                ret = true;
                break;
            }
        }
        return ret;
    }
    public boolean comprobarColor(String color){
        // solo comprueba que sea un color permitido, devuelve true o false
        boolean ret = false;
        for(int a=0; a < listaColores.length; a++){
            if(color.toLowerCase().equals(listaColores[a]) ){
                ret = true;
                break;
            }
        }
        return ret;
    }
    public void precioFinal(){
        // si encuentra la letra devuelve la posicion SIGUIENTE convertido a entero
        String[] letraPrecio = {"A", "100", "B", "80", "C", "60", "D", "50",
                                "E", "30", "F", "10"};

        for (int x = 0; x < letraPrecio.length; x++){
            if (Character.toString(this.consumoEnerg).equals( letraPrecio[x] ) ){
                this.precioBase += Integer.parseInt(letraPrecio[x+1]);
                // parsea a entero la posicion siguiente donde está la LETRA
                break;
            }
        }

        if(this.peso >= 0 && this.peso <= 19){
            this.precioBase += 10;
        } else if (this.peso >= 20 && this.peso <= 49){
            this.precioBase += 50;
        } else if (this.peso >= 50 && this.peso <= 79){
            this.precioBase += 80;
        } else if (this.peso >= 80 && this.peso <= 100){
            this.precioBase += 100;
        }
    }

    public static void main(String[] args) {
        Electrodomestico e = new Electrodomestico(500, "negro", 'a', 25);
        System.out.println(e.getPrecioBase());
        e.precioFinal();
        System.out.println(e.getPrecioBase());
        System.out.println(e.getColor());
        System.out.println(e.getConsumoEnerg());
    }
}
