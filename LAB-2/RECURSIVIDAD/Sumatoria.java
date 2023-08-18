/*
* Programa 2: Sumatoria Recursiva
* Escribe un programa que calcule la sumatoria de los números enteros desde 1 hasta un número dado utilizando
* una función recursiva. Implementa esta funcionalidad en una clase separada. Asegúrate de probar la función
* con diferentes valores de entrada.
* */
public class Sumatoria {
    public static int recursividad(int num){
        if (num == 1){
            System.out.println(Integer.toString(num));
            return 1;
        }
        System.out.printf(Integer.toString(num) + " + ");
        return num + recursividad(num-1);
    }


    public static void main(String[] args) {
        int rec = recursividad(7);
        System.out.printf("SUMATORIA: "+ rec);
    }
}
