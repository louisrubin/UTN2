package POO;

public class Main {
    public static void main(String[] args) {
        Electrodomestico [] array = new Electrodomestico[10];

        array[0] = new Lavarropas();
        array[1] = new Lavarropas(15);
        array[2] = new Lavarropas(12, 525, 25, 'e', "blanco");
        array[3] = new Television(22, false);
        array[4] = new Television(19, true);
        array[5] = new Television();
        array[6] = new Electrodomestico();
        array[7] = new Television(1500, 4.5);
        array[8] = new Lavarropas(2500, 28);
        array[9] = new Electrodomestico(3000, 'b', 12, "negro");

        double finalTelevisores=0, finalLavarropas=0, finalElectro=0;
        byte cantTelev=0, cantLava=0, cantElect=0;
        double lastPrice;

        for(int x=0; x < array.length; x++){
            lastPrice = array[x].precioFinal();

            if (array[x] instanceof Television){
                finalTelevisores += lastPrice;
                cantTelev++;
            }else if (array[x] instanceof Lavarropas ){
                finalLavarropas += lastPrice;
                cantLava++;
            }
            cantElect++;
            finalElectro += lastPrice;
        }

        System.out.println("\n Monto total TELEVISION (" +cantTelev+ "): $"+finalTelevisores);
        System.out.println(" Monto total LAVARROPAS (" +cantLava+ "): $"+finalLavarropas);
        System.out.println(" Monto total ELECTRODOMESTICOS (" +cantElect+ "): $"+finalElectro);
    }
}
