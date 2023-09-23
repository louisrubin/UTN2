package EjemParcial1;

import java.util.ArrayList;

public class Concesionaria {
    private ArrayList<Vehiculo> vehiculos;

    public Concesionaria(){
        vehiculos = new ArrayList<>();
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void eliminarVehiculo(String patente){
        for (Vehiculo ve : vehiculos){

        }
    }


    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
