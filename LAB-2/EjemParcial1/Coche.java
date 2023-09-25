package EjemParcial1;

// import java.io.Serializable;

import java.util.Scanner;

public class Coche extends Vehiculo implements java.io.Serializable {

    private String color;
    public Coche(){
        super();
        System.out.println("Nuevo Coche [patente "+this.getPatente() +"]");
    }
    public Coche(String color){
        super();
        this.color = color;
        System.out.println("Nuevo Coche [patente "+this.getPatente() +"]");
    }
    @Override
    public double calcularImpuesto() {
        // impuesto del 15%
        return this.getPrecio() * 0.85;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Coche [patente="+getPatente() +",marca="+this.getMarca() +
                ",modelo=" + this.getModelo()+ ",color=" +color + ",precio=$" + this.getPrecio() +"]");
    }

    @Override
    public void editarVehiculo(Scanner sc) {
        System.out.println("-ENTER para omitir campos-");
        try {
            System.out.print("\tNuevo color: ");
            String nuevoColor = sc.nextLine();
            if ( ! nuevoColor.isBlank() )     setColor(nuevoColor);

            System.out.print("\tMarca: ");
            String nuevaMarca = sc.nextLine();
            if ( ! nuevaMarca.isBlank())     setMarca( nuevaMarca );

            System.out.print("\tModelo: ");
            String nuevoModelo = sc.nextLine();
            if ( ! nuevoModelo.isBlank())     setModelo( nuevoModelo );

            try {
                System.out.print("\tPrecio (0 omitir): $");
                double nuevoPrecio = sc.nextDouble();
                if ( nuevoPrecio != 0.0){
                    setPrecio( nuevoPrecio );
                }
            } catch (Exception e) {
                System.out.println("Tipo de dato incorrecto.");
            }

            System.out.println("Editado con exito.");
        } catch (Exception e){
            System.out.println("Error editando Coche.");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
