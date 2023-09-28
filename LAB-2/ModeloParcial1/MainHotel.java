package ModeloParcial1;

import java.io.*;
import java.util.Scanner;

public class MainHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreHotel ="";

        try  {
            //todo LEYENDO EL NOMBRE DEL HOTEL DESDE UN ARCHIVO
            Scanner sc2 = new Scanner(new File(MostrarInformacion.nombreHotel));
            nombreHotel = sc2.nextLine();
        } catch (Exception e){
            System.out.println("Error leyendo el archivo. ->> " + e.getMessage());
        }
        Hotel hotel = new Hotel(nombreHotel);  // hotel principal

        while (true) {

            // todo MENU DENTRO DE UN WHILE
            //todo dsakjdsa dsadjkasdjk asdkajs dkasjdlak sjdaskldj askl

            System.out.print("----------------------------------------" +
                    "\n1. Ver Listado habitaciones " +
                    "\n2. Reservar habitacion" +
                    "\n3. Cancelar una reserva" +
                    "\n4. Guardar reservas en archivo" +
                    "\n5. Cargar reservas desde archivo" +
                    "\n6. SALIR" +
                    "\n -->  ");
                    int opc = sc.nextInt();
                    sc.nextLine();      // limpiar buffer
            System.out.println("\n----------------------------------------");


            switch (opc) {
                case 1:
                    // 1. Ver Listado habitaciones "
                    hotel.listadoHabit();
                    System.out.println();
                    break;

                case 2:
                    // 2. Reservar habitacion
                    System.out.print("Numero de Habitación: ");
                    int numHab = sc.nextInt();
                    sc.nextLine();      // limpiar buffer
                    if (numHab < 1 || numHab > 4) System.out.println("Nro habitacion erronea.");
                    else {
                        hotel.reservarHab(numHab, sc);
                        hotel.listadoHabit();
                    }

                    break;


                case 3:
                    // 3. Cancelar una reserva
                    System.out.print("Numero de Habitación: ");
                    numHab = sc.nextInt();
                    sc.nextLine();      // limpiar buffer
                    if (numHab < 1 || numHab > 4) System.out.println("Nro habitacion erronea.");
                    else {
                        hotel.cancelarReserva(numHab);
                        hotel.listadoHabit();
                    }
                    break;

                case 4:
                    // 4. Guardar reservas en archivo
                    String archivo = MostrarInformacion.archivoSerializador;

                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream( archivo ));
                        objectOutputStream.writeObject(hotel);
                        System.out.println("\tSerializado con exito.");
                    } catch (Exception e) {
                        System.out.println("Error al guardar las reservas. ->> "+ e.getMessage());
                    }
                    break;

                case 5:
                    // 5. Cargar reservas desde archivo
                    archivo = MostrarInformacion.archivoSerializador;
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream( archivo ));
                        Hotel deserializado = (Hotel) objectInputStream.readObject();

                        hotel = deserializado;

                        System.out.println("\tReservas cargadas con exito.");
                    } catch (Exception e) {
                        System.out.println("Error al cargar las reservas. ->> "+ e.getMessage());
                    }
                    break;

                case 6:
                    // 6. SALIR
                    System.exit(0);
                    break;
            }
        }
    }
}

class Hotel implements Serializable {
    public String nombreHotel;
    public Habitacion[] habitaciones = new Habitacion[4];

    // todo AGREGO LAS HABITACIONES A LA LISTA DE ESTE HOTEL
    public Hotel(String nombreHotel ) {
        this.nombreHotel = nombreHotel;
        this.habitaciones[0] = Habitacion.habitacion1;
        this.habitaciones[1] = Habitacion.habitacion2;
        this.habitaciones[2] = Habitacion.habitacion3;
        this.habitaciones[3] = Habitacion.habitacion4;
    }

    public void cancelarReserva(int nroHab){
        //todo CANCELAR RESERVA DE UNA HABITACION
        if (! habitaciones[nroHab-1].getOcupado()) System.out.println("Habitacion ya está desocupada");
        else {
            habitaciones[nroHab-1].setCantHuespedes(0);
            habitaciones[nroHab-1].setOcupado(false);
            habitaciones[nroHab-1].setHuespedes(null);
            System.out.println("Habitacion "+nroHab+" desalojada.");
        }
    }

    public void reservarHab(int nro, Scanner sc){
        //todo RESERVA DE UNA HABITACION
        Huesped[] huespeds;     // lista de Huesped que luego se usará para instancias Habitacion

        if (habitaciones[nro-1].getOcupado()){      // if getOcupado = true
            System.out.println("Habitacion ocupada.");
        } else {
            System.out.print("Cuantos huespedes quiere agregar: ");
            int cantPersonas = sc.nextInt();
            sc.nextLine();      // limpiar buffer

            huespeds = new Huesped[cantPersonas];

            for (int x =0; x <cantPersonas; x++){
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                try {
                    System.out.print("edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    huespeds[x] = new Huesped(nombre, edad);

                }catch (Exception e){
                    System.out.println("Tipo de dato incorrecto.");
                    sc.nextLine();
                    huespeds[x] = new Huesped(nombre);
                }
            }

            habitaciones[nro -1] =  new Habitacion(
                                                    habitaciones[nro -1].getCantCamas(),
                                                    cantPersonas,
                                                    true,
                                                    huespeds );
        }
    }

    public void listadoHabit(){
        // lista de todos las habitaciones
        int x = 1;
        System.out.println("   {");
        for (Habitacion h : habitaciones){
            System.out.println("\t Nro["+x+"] " + h.mostrarInfor());
            if (h.getOcupado()) listHuesp(h.getHuespedes());
            x++;
        }
        System.out.println("   }");
    }
    public void listHuesp(Huesped[] lista) {
        // lista de todos los huespedes a traves de una lista dada
        System.out.println("      {");
        for (Huesped h : lista){
            System.out.println("\t\t\t"+ " " + h.mostrarInfor());
        }
        System.out.println("       }");
    }

}

class Habitacion implements MostrarInformacion, Serializable{
    private int cantCamas, cantHuespedes;
    private boolean ocupado;
    private Huesped[] huespedes;    // lista de los huespedes que tendrá una habitacion

    public Habitacion(){
        // nada
    }
    public Habitacion(int cantCamas, int cantHuespedes, boolean ocupado, Huesped[] huespedes) {
        this.cantCamas = cantCamas;
        this.cantHuespedes = cantHuespedes;
        this.ocupado = ocupado;
        this.huespedes = huespedes;
    }

    // todo INSTANCIO Y SETEO LAS 4 HABITACIONES POR DEFECTO (ALGUNAS OCUPADAS)
    public static Habitacion habitacion1 = new Habitacion(2, Huesped.huesp1.length, true, Huesped.huesp1);
    public static Habitacion habitacion2 = new Habitacion(3, Huesped.huesp2.length, true, Huesped.huesp2);
    public static Habitacion habitacion3 = new Habitacion(4, 0, false, null);
    public static Habitacion habitacion4 = new Habitacion(1, 0, false, null);

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

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setCantHuespedes(int cantHuespedes) {
        this.cantHuespedes = cantHuespedes;
    }

    public void setHuespedes(Huesped[] huespedes) {
        this.huespedes = huespedes;
    }

    @Override
    public String mostrarInfor() {
        return "[Camas="+cantCamas+",Huespedes="+cantHuespedes+",Ocupado="+ocupado+"]";
    }
}

class Huesped extends Persona implements MostrarInformacion, Serializable{

    public Huesped(String nombre){
        super(nombre);
    }
    public Huesped(String nombre, int edad){
        super(nombre, edad);
    }
    public static Huesped[] huesp1 = {
            new Huesped("pedro", 29),
            new Huesped("sofia", 27)
    };
    public static Huesped[] huesp2 = {
            new Huesped("jose", 25),
            new Huesped("amanda", 24),
            new Huesped("carlitos", 5)
    };

    @Override
    public String mostrarInfor() {
        return "[nombre="+getNombre() + ",edad=" +getEdad() + "]";
    }

}

abstract class Persona implements Serializable {
    // clase Persona
    private String nombre;
    private int edad;
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    public Persona(String nombre, int edad){
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


interface MostrarInformacion {
    String archivoSerializador = "LAB-2" + File.separator + "ModeloParcial1" + File.separator + "serializado.txt";
    String nombreHotel = "LAB-2" + File.separator + "ModeloParcial1" + File.separator + "nombreHotel.txt";
    String mostrarInfor();

}