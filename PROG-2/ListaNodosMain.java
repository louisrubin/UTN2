import java.util.Scanner;

public class ListaNodosMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();

        while (true) {
            System.out.println("-------------------------------");
            System.out.print(" 1- Agregar al Inicio\n 2- Imprimir Lista\n 3- Agregar al Final\n" +
                    " 9- SALIR\n --> ");
            int opc = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------");

            switch (opc) {
                case 1:
                    System.out.print("Nuevo Valor: ");
                    int valor = sc.nextInt();
                    lista.agregarInicio(valor);
                    sc.nextLine();
                    break;

                case 2:
                    lista.imprimirLista();
                    break;

                case 3:
                    System.out.print("Nuevo Valor: ");
                    valor = sc.nextInt();
                    lista.agregarFinal(valor);
                    sc.nextLine();
                    break;

                case 9:
                    System.exit(0);
                    break;
            }
        }

    }

}

class Lista {
    Nodo primerNodo, ultNodo; //nuevoNodo;

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

        Nodo actual = primerNodo;
        Nodo nuevoNodo = new Nodo(valor);

        while (true){   // saldra del while en el IF
            if (actual.sig == null){
                actual.sig = nuevoNodo;
                ultNodo = nuevoNodo;
                return;
            }
            actual = actual.sig;
        }

    }

    public void imprimirLista(){
        if (primerNodo == null){
            System.out.println("\t\tLista vacia");
            return;
        }

        Nodo actual = primerNodo;
        while (actual.sig != null){
            System.out.print(actual.dato + ", ");
            actual = actual.sig;

        }
        System.out.println(actual.dato);
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
