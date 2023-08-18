/*
* Programa 3: Factorial con Sobrecarga (Recursión e Iteración)
* Crea un programa que calcule el factorial de un número utilizando dos métodos diferentes:
* uno utilizando recursión y otro utilizando iteración. Estos métodos deben estar en una clase
* distinta. Emplea la sobrecarga de métodos para diferenciar entre las dos implementaciones.
* Realiza pruebas del programa con distintos números enteros.
* */

public class Factorial {
    public static int factorial(int num){
        // sobrecarga de metodos, en este caso parámetro INT
        if(num < 2){
            System.out.println(Integer.toString(num));
            return 1;
        }
        System.out.printf(Integer.toString(num) + " x ");
        return num * factorial(num - 1);
    }

    public static double factorial(double num){
        // sobrecarga de metodos, en este caso parámetro DOUBLE
        if(num < 2){
            System.out.println(Double.toString(num));
            return 1;
        }
        System.out.printf(Double.toString(num) + " x ");
        return num * factorial(num - 1);
    }

    // MAIN
    public static void main(String[] args) {
        int rec1 = factorial(5);
        System.out.println("FACTORIAL: "+ rec1);

        System.out.println("---------------------------");

        double rec2 = factorial(5.0);
        System.out.println("FACTORIAL: "+ rec2);
    }
}
