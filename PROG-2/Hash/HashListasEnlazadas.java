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

        for (int x=0; x < sizeTabla; x++){
            tabla[x] = new ListaStr();      // crea una lista en la posicion del array
        }
    }

    public HashListasEnlazadas(int size) {
        tabla = new ListaStr[size];         // listas enlazada
        sizeTabla = size;

        for (int x=0; x < sizeTabla; x++){
            tabla[x] = new ListaStr();      // crea una lista en la posicion del array
        }
    }

    public void agregar(int key, String valor) {
        int indice = hashCode(key);   // indice

        /*if (tabla[indice] == null) {
            tabla[indice] = new ListaStr();
        }*/

        tabla[indice].agregarFinal(valor);    // agrega al final de la lista enlazada
    }

    private int hashCode(int key) {
        return key % sizeTabla;     // retorna un entero que es la ubicación hasheada
    }

    public void get(int clave) {
        System.out.print("[");
        tabla[ hashCode(clave)].imprimirLista();
        System.out.print("]");
    }

    public void imprimirValor(){
        //
    }

    public static void main(String[] args) {
        HashListasEnlazadas lista = new HashListasEnlazadas();

        lista.agregar(100, "SpongeBob");    // hash -> 0
        lista.agregar(550, "Gary");         // hash -> 0

        lista.get(101);     // imprime todos los valores en hash 100 -> 0
    }

}
