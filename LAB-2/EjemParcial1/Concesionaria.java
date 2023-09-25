package EjemParcial1;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Concesionaria implements Serializable, java.io.Serializable {
    private static final long serialVersionUID = 111222333;
    LinkedList<Vehiculo> vehiculos;

    public Concesionaria(){
        vehiculos = new LinkedList<>();
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


    public Vehiculo buscarVehiculo(String patente){
        // metodo privado para buscar y retornar un vehiculo a través de una patente

        for (Vehiculo ve : vehiculos){
            if (ve.getPatente().equals(patente)){
                return ve;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String marca, String modelo){
        // metodo privado para buscar y retornar un vehiculo a través de un modelo y marca

        for (Vehiculo ve : vehiculos){
            if (ve.getMarca().equals(marca) && ve.getModelo().equals(modelo) ){
                return ve;
            }
        }
        return null;
    }
    public int contadorMotos(){
        // contador de motos dentro del LinkedList
        int cantMoto = 0;
        if (vehiculos != null){
            for (Vehiculo ve : vehiculos){
                cantMoto += ve instanceof Moto ?  1 : 0;
            }
        }

        return cantMoto;
    }
    public int contadorCoche(){
        // contador de coches dentro del LinkedList
        int cantCoche = 0;
        if (vehiculos != null) {
            for (Vehiculo ve : vehiculos){
                cantCoche += ve instanceof Coche ?  1 : 0;
            }
        }
        return cantCoche;
    }
    @Override
    public void serializar(Concesionaria concesionaria) {
        String archivo = Serializable.archivo;  // ubicacion proveniente de la interfaz "Serializable"
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(archivo));
            objectOutputStream.writeObject(concesionaria);
            objectOutputStream.close();
            System.out.println("Serializado con exito.");
        }catch (Exception e){
            System.out.println("Error al serializar. --> " + e.getMessage() );
            System.exit(12);
        }
    }
    @Override
    public Concesionaria deserializar()  {
        Concesionaria deserializado;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Serializable.archivo));
            deserializado = (Concesionaria) objectInputStream.readObject();
            objectInputStream.close();

            this.vehiculos = deserializado.getVehiculos();      // deserializa y asigna el nuevo LinkedList al this.vehiculos

            System.out.println("Deserializado con exito.");
            return deserializado;
        } catch (Exception e) {
            System.out.println("Error al deserializar. ->> " + e.getMessage());
        }
        return null;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
