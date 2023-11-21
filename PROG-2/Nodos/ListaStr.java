package Nodos;

public class ListaStr {
    private Nodo primerNodo, ultNodo;
    private int length = 0;

    public ListaStr(){
        // ..
    }
    public ListaStr(String valor){
        agregarFinal(valor);
    }

    protected boolean ifVacioThenMessage(){
        if (primerNodo == null){    // verifica que la lista no esté vacia
            System.out.println("\t\tLista vacía");
            return true;    // retorna true pq la lista SI está vacía
        }
        return false;
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


    public void agregarInicio(String valor){
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

    public void imprimirLista(){
        if ( ! ifVacioThenMessage() ){
            Nodo actual = primerNodo;   // puntero
            while (actual.sig != null){
                System.out.print(actual.datoStr + ", ");
                actual = actual.sig;
            }
            System.out.print(actual.datoStr);    // imprime el ultimo valor encontrado
        }
    }
    public void imprimirListaInverso(){
        if ( ! ifVacioThenMessage() ) {
            Nodo actual = ultNodo;   // puntero
            while (actual.prev != null){
                System.out.print(actual.datoStr + ", ");
                actual = actual.prev;
            }
            System.out.println(actual.datoStr);    // imprime el ultimo valor encontrado
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
