package Grafos;

import Nodos.*;
import java.util.Arrays;

public class Grafo {
    ListaStr[] listaAdyacencias;
    int[][] matrizPesos;
    String[] vertices;

    public Grafo(String[] vertices) {
        this.vertices = vertices;
        matrizPesos = new int[vertices.length][vertices.length];

        this.listaAdyacencias = new ListaStr[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            listaAdyacencias[i] = new ListaStr(vertices[i]);
        }
    }

    public static void main(String[] args) {
        String[] verts = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        Grafo grafo = new Grafo(verts);


        grafo.conectar( verts[1], verts[5] );
        grafo.conectar( verts[9], verts[3] );
        /*grafo.conectar( verts[3], verts[1] );
        grafo.conectar( verts[6], verts[6] );*/

        grafo.imprimirStr();

    }

    public void conectar(String v1, String v2) {

        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);

        if (index1 != -1 && index2 != -1) {
            matrizPesos[index1][index2] = 1;    // matriz de adyacencias
            matrizPesos[index2][index1] = 1;

            listaAdyacencias[index1] = new ListaStr(v1);  // lista de adyacencias
            listaAdyacencias[index2] = new ListaStr(v2);

        }
    }

    public void imprimir() {

        /*      FUNCIONES LAMBDAS
        Este programa convierte el array de strings en una lista utilizando el método `asList`
        de la clase `Arrays`, y luego utiliza la función `forEach` junto con una expresión
        lambda para imprimir cada elemento del array en una misma línea.
         */
        Arrays.asList(vertices).forEach( elem -> System.out.print(elem + " "));
        System.out.println();

        for (int i = 0; i < matrizPesos.length; i++) {
            for (int j = 0; j < matrizPesos.length; j++) {
                System.out.print(matrizPesos[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimirStr() {

        /*Arrays.asList(vertices).forEach( elem -> System.out.print(elem + " "));
        System.out.println();*/

        for ( int i = 0; i < listaAdyacencias.length; i++ ) {
            System.out.print(vertices[i] + " está conectado con: ");
            listaAdyacencias[i].imprimirLista();
            System.out.println();
        }
    }

    private int busquedaIndex(String v) {
        int resultado = -1;

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(v)) {
                resultado = i;
                break;
            }
        }
        return resultado;
    }
}