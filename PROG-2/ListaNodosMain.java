package ListaNodos;

import java.util.Scanner;

public class ListaNodosMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();


        lista.agregarFinal(2);  // para ir probando
        lista.agregarFinal(4);
        lista.agregarFinal(6);
        lista.agregarFinal(8);
        lista.agregarFinal(10);

        lista.imprimirLista();
        lista.invertirLista();
        lista.imprimirListaInverso();

        while (true) {
            System.out.println("-------------------------------");
            System.out.print(" 1- Agregar al Inicio\n 2- Imprimir Lista ("+lista.getLength() + ")" +
                    "\n 3- Agregar al Final\n 4- Ultimo Elemento\n" +
                    " 5- Existe Valor\n 6- Eliminar posición\n" +
                    " 7- Agregar en posición\n 8- Modificar posición\n 9- SALIR\n --> ");
            int opc = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------");

            switch (opc) {
                case 1:
                    System.out.print("Nuevo Valor: ");
                    int valor = sc.nextInt();
                    sc.nextLine();
                    lista.agregarInicio(valor);
                    break;

                case 2:
                    lista.imprimirLista();
                    break;

                case 3:
                    System.out.print("Nuevo Valor: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.agregarFinal(valor);
                    break;

                case 4:
                    // imprime el ultimo elemento de la lista
                    System.out.print("Ult.: ");
                    if (lista.getUltNodo() == null) System.out.println("--");
                    else System.out.println(lista.getUltNodo().dato);
                    break;

                case 5:
                    if (lista.getPrimerNodo() == null){    // verifica que la lista no esté vacia
                        System.out.println("\t\tLista vacía");
                        break;
                    }
                    System.out.print("Valor a buscar: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.existeValor(valor);
                    break;
                case 6:
                    if (lista.getPrimerNodo() == null){    // verifica que la lista no esté vacia
                        System.out.println("\t\tLista vacía");
                        break;
                    }
                    System.out.print("Eliminar posición: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.eliminarElem(valor);
                    break;

                case 7:
                    System.out.print("Posición: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Valor: ");
                    int valor2 = sc.nextInt();
                    sc.nextLine();
                    lista.agregarMedio(valor, valor2);
                    break;

                case 8:
                    System.out.print("Posición: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.modifPosicion(valor, sc);
                    break;

                case 9:
                    System.exit(0);
                    break;
            }
        }
    }
}

class Lista {
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
        /*
        // metodo para invertir una lista (ultimo -> primero)
        if ( ! ifVacioThenMessage() ){
            Nodo actual = primerNodo;   // puntero 1
            Nodo actualPrev = ultNodo;     // puntero 2
            Nodo aux1, aux2;

            actual.imprimirNodo();
            actualPrev.imprimirNodo();

            int x = 1;
            while (actual.sig != null) {
                aux1 = actual;       // guarda el actual nodo
                aux2 = actualPrev;

                primerNodo = ultNodo;


                actual = actualPrev;        // se asigna al puntero que regresa
                actualPrev = aux1;

                if (x == 1 || x == getLength() ){
                    // la 1ra y ultima vuelta tienen un camino diferente ( primerNodo.prev es null por eso)
                    actual.prev = (aux1.prev != null) ? aux1.prev : null;
                    actual.sig = (aux1.sig != null) ? aux1.sig : null;

                    actualPrev.prev = (aux2.prev != null) ? aux2.prev : null;
                    actualPrev.sig = (aux2.sig != null) ? aux2.sig : null;
                } else {    // vuelta > 1
                    actual.prev = aux1.prev;
                    actual.sig = aux1.sig;

                    actualPrev.prev = aux2.prev;
                    actualPrev.sig = aux2.sig;
                }

                actual = actual.sig;
                actualPrev = actualPrev.prev;

                System.out.println(actual.dato);
                x++;
            }
        }

         */
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

class Nodo {
    protected int dato;
    protected Nodo prev, sig;

    public Nodo(){
        // ..
    }
    public Nodo(int valor){
        this.dato = valor;
    }
    public Nodo(Nodo prev, int valor) {
        // directamente se enlaza los nodos al instanciarlo
        this.prev = prev;
        this.dato = valor;
    }
    public Nodo(int valor, Nodo sig) {
        // directamente se enlaza los nodos al instanciarlo
        this.dato = valor;
        this.sig = sig;
    }
    public Nodo(Nodo prev, int valor, Nodo sig) {
        // directamente se enlaza los nodos al instanciarlo
        this.prev = prev;
        this.dato = valor;
        this.sig = sig;
    }
    public void imprimirNodo(){
        // imprime los datos del nodo actual

        if (prev == null) System.out.print( "--, ");
        else System.out.print(prev.dato + ", ");

        System.out.print(dato + ", ");

        if (sig == null) System.out.print( "--");
        else System.out.print(sig.dato);

        System.out.println();
    }
}
