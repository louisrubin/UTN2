package Nodos;

import java.util.Scanner;

public class Lista {
    private Nodo primerNodo, ultNodo;
    private int length = 0;

    public Lista(){
        // ..
    }
    protected boolean ifVacioThenMessage(){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            System.out.println("\t\tLista vacía");
            return true;    // retorna true pq la lista SI está vacía
        }
        return false;
    }

    public void modifPosicion(int posiParam, Scanner sc){
        if ( ! ifVacioThenMessage() ){
            Nodo actual = primerNodo;   // puntero
            int x = 1;  // indice
            while (true) {
                if (x == posiParam) {   // ubicacion encontrada
                    System.out.print("Nuevo Valor: ");
                    int nuevoValor = sc.nextInt();
                    sc.nextLine();      // limpiar buffer
                    actual.dato = nuevoValor;
                    System.out.println("ok.");
                    return;
                }
                if (actual.sig == null) {   // condicion de cierre While
                    System.out.println("No existe esa posición.");
                    return;
                }
                actual = actual.sig;    // avanza una posicion el puntero
                x++;
            }
        }
    }

    public void eliminarElem(int posicion){
        if ( ! ifVacioThenMessage() ){    // verifica que la lista no esté vacia

            int x = 1;   // indice
            Nodo actual = primerNodo;   // puntero
            while (true){   // saldra del while en el IF
                if (posicion == 1){
                    // elimina el nodo en la primera posicion
                    if (actual.sig == null) {
                        primerNodo = null;  // si solo hay un unico elemento
                        ultNodo = null;

                        length --;
                        System.out.println("ok.");
                        return;
                    }
                    primerNodo = actual.sig;
                    actual.prev = null;         // el 'anterior' del primer elemento será null

                    length --;
                    System.out.println("ok.");
                    return;
                }
                if (x == posicion){     // elimina la posicion actual != 1
                    actual.prev.sig = actual.sig;       // enlaza los nodos, eliminando el actual

                    if (actual.sig != null){
                        actual.sig.prev = actual.prev;
                    } else {
                        ultNodo = actual.prev;    // actualiza quien es el ultimo Nodo de la lista
                    }
                    length --;
                    System.out.println("ok.");
                    return;
                }
                if (actual.sig == null){    // final de la lista
                    System.out.println("No existe esa posición.");
                    return;
                }
                x++;
                actual.prev = actual;       // guarda el nodo anterior
                actual = actual.sig;        // avanza una posicion
            }
        }
    }

    public void agregarMedio(int posicion, int valor){
        //todo agrega atrás de la posicion elegida
        if (primerNodo == null){    // verifica que si la lista está vacia
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo

            length++;
            System.out.println("ok.");
            return;
        }

        int x = 1;      // indice
        Nodo actual = primerNodo;   // puntero
        Nodo nuevoNodo;

        if (posicion == 1){
            //agregarInicio(valor);       // reutiliza metodo
            //return;
            nuevoNodo = new Nodo(null, valor, actual);
            actual.prev = nuevoNodo;
            primerNodo = nuevoNodo;

            length++;
            System.out.println("ok.");
            return;

        }

        while (true){   // saldra del while en el IF
            if (x == posicion){
                nuevoNodo = new Nodo(actual.prev, valor, actual);
                actual.prev.sig = nuevoNodo;
                actual.prev = nuevoNodo;

                length++;
                System.out.println("ok.");
                return;
            }
            if (actual.sig == null){    // una longitud mayor a la lista agrega al final
                agregarFinal(valor);
                System.out.println("ok.");
                return;
            }
            actual = actual.sig;        // avanza una posicion
            x++;
        }
    }

    public void agregarFinal(String valor){     // ENTRADA STRING
        if (primerNodo == null){
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo

            length++;
            return;
        }
        Nodo nuevoNodo = new Nodo(ultNodo, valor);   // enlaza el ultimo nodo con el nuevo
        ultNodo.sig = nuevoNodo;
        ultNodo = nuevoNodo;

        length++;
    }

    public void agregarFinal(int valor){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo

            length++;
            return;
        }
        Nodo nuevoNodo = new Nodo(ultNodo, valor);   // enlaza el ultimo nodo con el nuevo
        ultNodo.sig = nuevoNodo;
        ultNodo = nuevoNodo;

        length++;
    }

    public void agregarInicio(int valor){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo

            length++;
            return;
        }
        Nodo nuevoNodo = new Nodo(valor, primerNodo);

        primerNodo.prev = nuevoNodo;    // el primer nodo asigna su 'anterior' al nuevo nodo
        primerNodo = nuevoNodo;     // el nuevo nodo pasa a ser el primero

        length++;
    }
    public boolean existeValor(int valorParam){
        if ( ! ifVacioThenMessage() ){
            Nodo actual = primerNodo;   // puntero

            while (actual != ultNodo.sig){   // saldra del while en el IF
                if (actual.dato == valorParam) {
                    System.out.println(true);
                    return true;
                }
                actual = actual.sig;        // avanza una posicion

            }
        }
        System.out.println(false);
        return false;
    }

    public void invertirLista() {
        // metodo para invertir una lista (ultimo -> primero)
        if ( ! ifVacioThenMessage() ){
            Nodo actual = primerNodo;   // puntero 1
            Nodo actualPrev = ultNodo;     // puntero 2
            Nodo aux1, aux2;

            //actual.imprimirNodo();
            //actualPrev.imprimirNodo();

            int x = 1;
            /*
            while (true) {
                if (x==2) {
                    actual.imprimirNodo();
                    actualPrev.imprimirNodo();
                }
                aux1 = actual;       // guarda el actual nodo
                aux2 = actualPrev;

                actual = aux2;        // se asigna al puntero que regresa
                actualPrev = aux1;

                actual.imprimirNodo();

                actual.prev = (aux1.prev != null) ? aux1.prev : null;
                actual.sig = (aux1.sig != null) ? aux1.sig : null;

                actual.imprimirNodo();
                actualPrev.imprimirNodo();

                actualPrev.prev = (aux2.prev != null) ? aux2.prev : null;
                actualPrev.sig = (aux2.sig != null) ? aux2.sig : null;

                actualPrev.imprimirNodo();

                if (actual.sig == null) return;

                actual = actual.sig;
                actualPrev = actualPrev.prev;
                x++;


            }   */
        }
    }

    public void imprimirLista(){
        if ( ! ifVacioThenMessage() ){
            Nodo actual = primerNodo;   // puntero
            while (actual.sig != null){
                System.out.print(actual.dato + ", ");
                actual = actual.sig;
            }
            System.out.println(actual.dato);    // imprime el ultimo valor encontrado
        }
    }
    public void imprimirListaInverso(){
        if ( ! ifVacioThenMessage() ) {
            Nodo actual = ultNodo;   // puntero
            while (actual.prev != null){
                System.out.print(actual.dato + ", ");
                actual = actual.prev;
            }
            System.out.println(actual.dato);    // imprime el ultimo valor encontrado
        }
    }


    public Nodo getPrimerNodo() {
        return primerNodo;
    }

    public Nodo getUltNodo() {
        return ultNodo;
    }

    public int getLength() {
        // longitud de la lista
        return length;
    }
}