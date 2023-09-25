package EjemParcial1;

import java.util.Scanner;

public class Moto extends Vehiculo implements java.io.Serializable {
    private int cilindrada;

    public Moto(){
        super();
        System.out.println("Nueva Moto [patente "+this.getPatente() +"]");
    }
    public Moto(int cilindrada){
        super();
        this.cilindrada = cilindrada;
        System.out.println("Nueva Moto [patente "+this.getPatente() +"]");
    }
    @Override
    public double calcularImpuesto() {
        // impuesto del 9%
        return this.getPrecio() * 0.91;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Moto [patente="+getPatente() +",marca="+this.getMarca() +
                ",modelo=" + this.getModelo()+",cilindrada="+this.cilindrada +
                ",precio=$" + this.getPrecio() +"]");
    }

    @Override
    public void editarVehiculo(Scanner sc) {
        System.out.println("-ENTER para omitir campos-");
        try {
            try {
                System.out.print("\tNueva cilindrada (0 omitir): ");
                int nuevaCilindr = sc.nextInt();
                if ( nuevaCilindr != 0) setCilindrada( nuevaCilindr );
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Tipo de dato incorrecto.");
            }

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
            System.out.println("Error editando Moto.");
        }
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

}
