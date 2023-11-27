package Hash;

import Nodos.ListaStr;

// ENCADENAMIENTO SEPARADO CON LISTAS ENLAZADAS: El array de indices hash posee un puntero
// a una lista enlazada que es donde se almacenan los valores.

public class HashListasEnlazadas {

    private ListaStr[] tabla;   // array de la clase ListaStr (Lista String)
    private int sizeTabla;

    public HashListasEnlazadas() {        // por defecto: tamaño de 10
        tabla = new ListaStr[10];         // listas enlazada
        sizeTabla = 10;
    }

    public HashListasEnlazadas(int size) {
        tabla = new ListaStr[size];         // listas enlazada
        sizeTabla = size;
    }

    public void agregar(int key, String valor) {
        int index = 0;
        int hashCode = hashCode(key);   // indice

        tabla[hashCode].agregarFinal(valor);    // agrega al final de la lista enlazada
    }

    private int hashCode(int key) {
        return key % sizeTabla;     // retorna un entero que es la ubicación hasheada
    }


}