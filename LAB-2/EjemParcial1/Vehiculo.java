package EjemParcial1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Vehiculo {
    private String marca, modelo, patente;
    private double precio;
    private final char[] listaPatente = {'q','k','m','o','h','f',
                                        '1','2','3','6','7','8'};
    private static ArrayList<String> patentesRegistradas = new ArrayList<>();   // almacena todas las patentes creadas

    public Vehiculo(){
        this.patente = asignarNuevaPatente();
        patentesRegistradas.add(this.patente);      // agrega la nueva pantente a los registrados
    }


    public String asignarNuevaPatente(){
        // metodo que crea y verifica que no exista la nueva patente
        String nuevaPatente = crearPatente(listaPatente);
        while ( patenteExist(nuevaPatente) ) {
            nuevaPatente = crearPatente(listaPatente);
        }
        return nuevaPatente;
    }

    private boolean patenteExist(String patenteParam){
        for (String patente : patentesRegistradas){
            if (patente.equals(patenteParam)){
                return true;
            }
        }
        return false;
    }

    private String crearPatente(char[] lista){
        // metodo que genera una patente aleatorio
        String string ="";
        Random random = new Random();
        for (int x=0; x<3; x++){
            int indice = random.nextInt(lista.length);
            string += lista[indice] ;
        }
        return string;
    }
    public abstract double calcularImpuesto();
    public abstract void mostrarInformacion();
    public abstract void editarVehiculo(Scanner sc);

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPatente() {
        return patente;
    }

    public ArrayList<String> getPatentesRegistradas() {
        return patentesRegistradas;
    }
}
