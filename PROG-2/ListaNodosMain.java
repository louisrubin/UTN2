import java.util.Scanner;

public class ListaNodosMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();

        lista.agregarFinal(3);  // para ir probando
        lista.agregarFinal(4);
        lista.agregarFinal(5);

        while (true) {
            System.out.println("-------------------------------");
            System.out.print(" 1- Agregar al Inicio\n 2- Imprimir Lista\n 3- Agregar al Final\n" +
                    " 4- Ultimo Valor\n 5- Existe Valor\n 9- SALIR\n --> ");
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
                    if (lista.ultNodo == null) System.out.println("\t\tLista vacia");   // si no hay datos agregados
                    else System.out.println("Ult.: "+ lista.ultNodo.dato);
                    break;

                case 5:
                    System.out.print("Valor a buscar: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.existeValor(valor);
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

    public void agregarInicio(int valor){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo
            return;
        }
        Nodo nuevoNodo = new Nodo(valor);

        nuevoNodo.sig = primerNodo;
        primerNodo = nuevoNodo;
    }
    public void agregarFinal(int valor){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            primerNodo = new Nodo(valor);
            ultNodo = primerNodo;       // el ultimo nodo
            return;
        }

        Nodo actual = primerNodo;   // puntero
        Nodo nuevoNodo = new Nodo(valor);

        while (true){   // saldra del while en el IF
            if (actual.sig == null){
                actual.sig = nuevoNodo;
                ultNodo = nuevoNodo;
                return;
            }
            actual = actual.sig;        // avanza una posicion
        }
    }

    public boolean existeValor(int valorParam){
        if (primerNodo == null){
            System.out.println("\t\tLista vacia");
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
            System.out.println("\t\tLista vacia");
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
    Nodo sig;

    public Nodo(){
        // ..
    }
    public Nodo(int valor){
        this.dato = valor;
    }
}
