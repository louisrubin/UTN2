package EjemParcial1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concesionaria concesionaria = new Concesionaria();     // vehiculos = new ArrayList<>();

        while (true) {
            // ciclo while que se cierra en el case 6 que mata al programa directamente

            System.out.print("1. Agregar Coche \n2. Agregar Moto \n3. Eliminar un Vehiculo" +
                            "\n4. Editar un Vehiculo\n5. Listar todos los Vehiculos\n6. Salir\n --> ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    // agregar coche
                    try {
                        System.out.print("Color coche: ");
                        String color = sc.nextLine();
                        Coche coche = new Coche(color);

                        concesionaria.agregarVehiculo( coche );
                        System.out.println("Coche agregado con exito.");

                        concesionaria.serializar(concesionaria);     // serializa cada vez que se agrega un vehiculo

                    } catch (Exception e) {
                        System.out.println("Error al agregar un Coche");
                    }
                    break;

                case 2:
                    // agregar moto
                    try {
                        System.out.print("Cilindrada: ");
                        int cilindrada = sc.nextInt();
                        Moto moto = new Moto(cilindrada);

                        concesionaria.agregarVehiculo( moto );
                        System.out.println("Coche agregado con exito.");

                        concesionaria.serializar(concesionaria);     // serializa cada vez que se agrega un vehiculo

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
                    sc.close();
                    System.exit(0);
                }

            }
        }
}
