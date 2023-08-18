/*
    RUBIN AZAS Miguel A. - LAB 2
*Programa 1: División con Restas (Recursión e Iteración)
Desarrolla un programa que realice la división de dos números
enteros utilizando tanto el enfoque recursivo como el iterativo
con restas sucesivas. Implementa ambos enfoques en la misma clase,
utilizando la sobrecarga de métodos para diferenciarlos. Luego,
realiza pruebas utilizando distintos pares de números.
* */
public class Divisiones {
    public static int division(int dividendo, int divisor){
        System.out.println("int");
        int cociente=0;
        while (divisor <= dividendo){
            dividendo -= divisor;
            cociente++;
        }
        System.out.println("Cociente: "+cociente);
        System.out.println("Resto: "+dividendo);
        return cociente;
    }


    public static double division(double dividendo, double divisor){
        System.out.println("double");
        double cociente=0;
        while (divisor <= dividendo){
            dividendo -= divisor;
            cociente++;
        }
        System.out.println("Cociente: "+cociente);
        System.out.println("Resto: "+dividendo);
        return cociente;
    }


    // MAIN
    public static void main(String[] args) {
        division(7504,12);
        System.out.println("------------------");
        division(7504.0,12.0);
    }
}
