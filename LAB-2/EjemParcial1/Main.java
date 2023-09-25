package EjemParcial1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concesionaria concesionaria = new Concesionaria();     // vehiculos = new LinkedList<>();
        concesionaria.deserializar();       // deserializar al arrancar el programa

        while (true) {
            // ciclo while que se cierra en el case 6 que mata al programa directamente
            System.out.println("--------------------------------------");
            System.out.print("1. Agregar Coche (" + concesionaria.contadorCoche() + ")" +
                            "\n2. Agregar Moto " + "(" + concesionaria.contadorMotos() + ")" +
                            "\n3. Eliminar un Vehiculo" + "\n4. Editar un Vehiculo" +
                            "\n5. Listar todos los Vehiculos\n6. Serializar y SALIR\n --> ");
            int opc = sc.nextInt();
            System.out.println("--------------------------------------");
            sc.nextLine();

            switch (opc) {
                case 1:
                    // agregar coche
                    try {
                        System.out.print("Color coche: ");
                        String color = sc.nextLine();
                        concesionaria.agregarVehiculo( new Coche(color) );

                        System.out.println("Coche agregado con exito.");

                    } catch (Exception e) {
                        System.out.println("Error al agregar un Coche");
                    }
                    break;

                case 2:
                    // agregar moto
                    try {
                        System.out.print("Cilindrada: ");
                        int cilindrada = sc.nextInt();

                        concesionaria.agregarVehiculo( new Moto(cilindrada) );
                        System.out.println("Moto agregada con exito.");

                        //concesionaria.serializar(concesionaria);     // serializa cada vez que se agrega un vehiculo

                    } catch (Exception e) {
                        System.out.println("Error al agregar una Moto");
                    }
                    break;

                case 3:
                    // eliminar vehiculo
                    System.out.print("Patente: ");
                    String patente = sc.nextLine();
                    concesionaria.eliminarVehiculo(patente);
                    break;

                case 4:
                    // editar vehiculo
                    System.out.print("Patente: ");
                    patente = sc.nextLine();

                    Vehiculo vehiculo = concesionaria.buscarVehiculo(patente);  // busca y retorna el vehiculo registrado
                    if ( vehiculo != null ){
                        vehiculo.editarVehiculo(sc);
                    } else System.out.println("No existe esa patente.");
                    break;

                case 5:
                    // mostrar todos los vehiculos
                    concesionaria.mostrarInventario();
                    break;

                case 6:
                    // salir del programa
                    concesionaria.serializar(concesionaria);    // serializa antes de cerrar el programa
                    sc.close();             // ciera el Scanner
                    System.exit(0);
                }

            }
        }
}
