package ModeloParcial1;

import java.util.Scanner;

public class MainHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // todo MENU DENTRO DE UN WHILE
        //todo dsakjdsa dsadjkasdjk asdkajs dkasjdlak sjdaskldj askl

        System.out.println("1. Ver Listado habitaciones \n2. Reservar habitacion" +
                "\n3. Cancelar una reserva\n4. Guardar reservas en archivo" +
                "\n5. Cargar reservas desde archivo\n6. SALIR");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                hotel.listadoHabit();
                break;
            case 2:
                System.out.print("Numero de Habitación: ");
                int numHab = sc.nextInt();
                sc.nextLine();
                if (numHab < 1 || numHab > 4) System.out.println("Nro habitacion erronea.");
                else {
                    hotel.reservarHab(numHab, sc);
                    hotel.listadoHabit();
                }

                break;


            case 3:
                System.out.print("Numero de Habitación: ");
                numHab = sc.nextInt();
                sc.nextLine();
                if (numHab < 1 || numHab > 4) System.out.println("Nro habitacion erronea.");
                else {
                    hotel.cancelarReserva(numHab);
                    hotel.listadoHabit();
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
}

class Hotel {
    public final String nombreHotel = "Cobadonga";
    public Habitacion[] habitaciones = new Habitacion[4];

    Huesped[] huesp1 = {
            new Huesped("pedro", 29),
            new Huesped("sofia", 27)
    };
    Huesped[] huesp2 = {
            new Huesped("jose", 25),
            new Huesped("amanda", 24),
            new Huesped("carlitos", 5)
    };

    Habitacion hab1 = new Habitacion(2, 2, true, huesp1);
    Habitacion hab2 = new Habitacion(3, 3, true, huesp2);
    Habitacion hab3 = new Habitacion(4, 0, false, null);
    Habitacion hab4 = new Habitacion(1, 0, false, null);

    public Hotel(){
        this.habitaciones[0] = hab1;
        this.habitaciones[1] = hab2;
        this.habitaciones[2] = hab3;
        this.habitaciones[3] = hab4;
    }

    public void cancelarReserva(int nroHab){
        if (! habitaciones[nroHab-1].getOcupado()) System.out.println("Habitacion ya está desocupada");
        else {
            habitaciones[nroHab-1].setCantHuespedes(0);
            habitaciones[nroHab-1].setOcupado(false);
            habitaciones[nroHab-1].setHuespedes(null);
            System.out.println("Habitacion "+nroHab+" cancelado.");
        }
    }

    public void reservarHab(int nro, Scanner sc){
        Huesped[] huespeds = new Huesped[2];
        if (habitaciones[nro-1].getOcupado()){
            System.out.println("Habitacion ocupada.");
        } else {
            for (int x =0; x<2; x++){
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                try {
                    System.out.print("edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    huespeds[x] = new Huesped(nombre, edad);

                }catch (Exception e){
                    System.out.println("Tipo de dato incorrecto.");
                    huespeds[x] = new Huesped(nombre);
                }
            }

            // FOR INGRESAR CANTIDAD HUESPEDES
            habitaciones[nro-1] = new Habitacion(habitaciones[nro].getCantCamas(),
                    2, true, huespeds);
        }
    }

    public void listadoHabit(){
        int x = 1;
        System.out.println("   {");
        for (Habitacion h : habitaciones){
            System.out.println("\t Nro "+x +" " + h.toString());
            if (h.getOcupado()) listHuesp(h.getHuespedes());
            x++;
        }
        System.out.println("   }");
    }
    public void listHuesp(Huesped[] lista) {
        System.out.println("      {");
        for (Huesped h : lista){
            System.out.println("\t\t\t"+ " " + h.toString());
        }
        System.out.println("       }");
    }

}

class Habitacion {
    private int cantCamas, cantHuespedes;
    private boolean ocupado;
    private Huesped[] huespedes;

    public Habitacion(){

    }
    public Habitacion(int cantCamas, int cantHuespedes, boolean ocupado, Huesped[] huespedes) {
        this.cantCamas = cantCamas;
        this.cantHuespedes = cantHuespedes;
        this.ocupado = ocupado;
        this.huespedes = huespedes;
    }
    public boolean getOcupado(){
        return ocupado;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public Huesped[] getHuespedes() {
        return huespedes;
    }

    public int getCantHuespedes() {
        return cantHuespedes;
    }

    @Override
    public String toString() {
        return "[Camas="+cantCamas+",Huespedes="+cantHuespedes+",Ocupado="+ocupado+"]";
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setCantHuespedes(int cantHuespedes) {
        this.cantHuespedes = cantHuespedes;
    }

    public void setHuespedes(Huesped[] huespedes) {
        this.huespedes = huespedes;
    }
}

class Huesped {
    private String nombre;
    private int edad;

    public Huesped(String nombre){
        this.nombre = nombre;
    }
    public Huesped(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "[nombre="+nombre+",edad="+edad+"]";
    }
}