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
        System.out.println("iteración\n"+ dividendo + "/" + divisor);
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
        int cocient = 0;
        if(dividendo < divisor){
            return cocient;
        }
        cocient++;
        return cocient + division(dividendo - divisor, divisor);

        // improvisando logré que funcione XD porque andaba pero me tiraba el resto y no el cociente
    }

    // MAIN
    public static void main(String[] args) {
        int div = 7504, div2 = 12;

        division(7504,12);
        System.out.println("------------------");
        System.out.println("recursión\n"+div + "/"+div2);
        System.out.println("=> " +division(Integer.toUnsignedLong(div), Integer.toUnsignedLong(div2)));
    }
}
