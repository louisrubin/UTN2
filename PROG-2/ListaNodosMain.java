package ListaNodos;

import java.util.Scanner;

public class ListaNodosMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();


        lista.agregarFinal(2);  // para ir probando
        lista.agregarFinal(4);
        lista.agregarFinal(6);

        while (true) {
            System.out.println("-------------------------------");
            System.out.print(" 1- Agregar al Inicio\n 2- Imprimir Lista\n 3- Agregar al Final\n" +
                    " 4- Ultimo Elemento\n 5- Existe Valor\n 6- Eliminar posición\n" +
                    " 7- Agregar Elemento\n 9- SALIR\n --> ");
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
                    if (lista.ultNodo == null) System.out.println("--");
                    else System.out.println(lista.ultNodo.dato);
                    break;

                case 5:
                    if (lista.primerNodo == null){    // verifica que la lista no esté vacia
                        System.out.println("\t\tLista vacía");
                        break;
                    }
                    System.out.print("Valor a buscar: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.existeValor(valor);
                    break;
                case 6:
                    if (lista.primerNodo == null){    // verifica que la lista no esté vacia
                        System.out.println("\t\tLista vacía");
                        break;
                    }
                    System.out.print("Eliminar posicion: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.eliminarElem(valor);
                    break;

                case 7:
                    System.out.print("Posicion: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Valor: ");
                    int valor2 = sc.nextInt();
                    sc.nextLine();
                    lista.agregarMedio(valor, valor2);
                    break;

                case 9:
                    System.exit(0);
                    break;
            }
        }

    }

}

class Lista {
    Nodo primerNodo, ultNodo;

    public Lista(){
        // ..
    }

    public void eliminarElem(int posicion){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            System.out.println("\t\tLista vacía");
            return;
        }

        int x = 1;   // contador
        Nodo actual = primerNodo;   // puntero
        while (true){   // saldra del while en el IF
            if (posicion == 1){
                // elimina el nodo en la primera posicion
                if (actual.sig == null) {
                    primerNodo = null;  // si solo hay un unico elemento
                    ultNodo = null;
                    System.out.println("ok.");
                    return;
                }
                primerNodo = actual.sig;
                actual.prev = null;         // el 'anterior' del primer elemento será null
                System.out.println("ok.");
                return;
            }
            if (x == posicion){
                // elimina la posicion actual != 1
                actual.prev.sig = actual.sig;       // enlaza los nodos, eliminando el actual

                if (actual.sig != null){
                    actual.sig.prev = actual.prev;
                } else {
                    ultNodo = actual.prev;    // actualiza quien es el ultimo Nodo de la lista
                }
                System.out.println("ok.");
                return;
            }
            if (actual.sig == null){
                // final de la lista
                System.out.println("No existe esa posición.");
                return;
            }
            x++;
            actual.prev = actual;       // guarda el nodo anterior
            actual = actual.sig;        // avanza una posicion
        }
    }

    public void agregarMedio(int posicion, int valor){
        //todo agrega atrás de la posicion elegida
        if (primerNodo == null){    // verifica que si la lista está vacia
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo
            System.out.println("ok.");
            return;
        }

        int x = 1;      // indice
        Nodo actual = primerNodo;   // puntero
        Nodo nuevoNodo;

        if (posicion == 1){
            nuevoNodo = new Nodo(null, valor, actual);
            actual.prev = nuevoNodo;
            primerNodo = nuevoNodo;
            System.out.println("ok.");
            return;
        }

        while (true){   // saldra del while en el IF
            if (x == posicion){
                nuevoNodo = new Nodo(actual.prev, valor, actual);
                actual.prev.sig = nuevoNodo;
                actual.prev = nuevoNodo;
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
            return;
        }
        Nodo nuevoNodo = new Nodo(ultNodo, valor);   // enlaza el ultimo nodo con el nuevo
        ultNodo.sig = nuevoNodo;
        ultNodo = nuevoNodo;
    }

    public void agregarInicio(int valor){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo
            return;
        }
        Nodo nuevoNodo = new Nodo(valor, primerNodo);

        primerNodo.prev = nuevoNodo;    // el primer nodo asigna su 'anterior' al nuevo nodo
        primerNodo = nuevoNodo;     // el nuevo nodo pasa a ser el primero
    }
    public boolean existeValor(int valorParam){
        if (primerNodo == null){
            System.out.println("\t\tLista vacía");
            return false;
        }

        Nodo actual = primerNodo;   // puntero

        while (actual != ultNodo.sig){   // saldra del while en el IF
            if (actual.dato == valorParam) {
                System.out.println("Si existe.");
                return true;
            }
            actual = actual.sig;        // avanza una posicion

        }
        System.out.println("No existe.");
        return false;
    }

    public void imprimirLista(){
        if (primerNodo == null){
            System.out.println("\t\tLista vacía");
            return;
        }

        Nodo actual = primerNodo;   // puntero
        while (actual.sig != null){
            System.out.print(actual.dato + ", ");
            actual = actual.sig;
        }
        System.out.println(actual.dato);    // imprime el ultimo valor
    }

}

class Nodo {
    int dato;
    Nodo prev, sig;

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
}
