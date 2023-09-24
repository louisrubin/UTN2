package EjemParcial1;

import java.util.ArrayList;
import java.util.Scanner;

public class Concesionaria {
    private ArrayList<Vehiculo> vehiculos;

    public Concesionaria(){
        vehiculos = new ArrayList<>();
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void agregarVehiculo(Vehiculo vehiculo, Vehiculo vehiculo2, Vehiculo vehiculo3){
        vehiculos.add(vehiculo);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
    }
    public void eliminarVehiculo(String patente){
        Vehiculo veh = buscarVehiculo(patente);    // metodo de busqueda de vehiculo
        if (veh != null) {
            vehiculos.remove(veh);
            System.out.println("Vehiculo eliminado.");
        } else System.out.println("No existe esa patente.");
    }
    public void eliminarVehiculo(String marca, String modelo){
        Vehiculo veh = buscarVehiculo(marca, modelo);    // metodo de busqueda de vehiculo
        if (veh != null){
            vehiculos.remove(veh);
            System.out.println("Vehiculo eliminado.");
        } else System.out.println("No existe un vehiculo con esas características.");
    }

    public void editarPrecio(String patenteParam, Scanner sc){
        Vehiculo veh = buscarVehiculo(patenteParam);    // metodo de busqueda de vehiculo
        if (veh != null){
            System.out.print("Ingrese nuevo precio: $");
            double nuevoPrecio = sc.nextDouble();
            veh.setPrecio(nuevoPrecio);
            sc.nextLine();      // consumir la linea vacia en el buffer
            return;
        }
        System.out.println("No existe esa patente.");
    }

    public void mostrarInventario(){
        System.out.println("  {");
        for ( Vehiculo veh : vehiculos) {
            System.out.print("\t");
            veh.mostrarInformacion();
        }
        System.out.println("  }");
    }



    private Vehiculo buscarVehiculo(String patente){
        // metodo privado para buscar y retornar un vehiculo a través de una patente
        for (Vehiculo ve : vehiculos){
            if (ve.getPatente().equals(patente)){
                return ve;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculo(String marca, String modelo){
        // metodo privado para buscar y retornar un vehiculo a través de un modelo y marca
        for (Vehiculo veh : vehiculos){
            if (veh.getMarca().equals(marca) && veh.getModelo().equals(modelo) ){
                return veh;
            }
        }
        return null;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }


    public static void main(String[] args) {
        Concesionaria concesionaria = new Concesionaria();
        Scanner sc = new Scanner(System.in);

        Coche c1 = new Coche("gris");
        Coche c2 = new Coche();
        Coche c3 = new Coche("blanco");

        Moto m1 = new Moto(150);
        Moto m2 = new Moto(110);
        Moto m3 = new Moto();

        concesionaria.agregarVehiculo(c1, c2, c3);
        concesionaria.agregarVehiculo(m1, m2, m3);


        String patente = sc.nextLine();
        concesionaria.eliminarVehiculo(patente);

        concesionaria.mostrarInventario();
    }
}
