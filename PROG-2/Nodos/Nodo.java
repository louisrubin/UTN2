package Nodos;

public class Nodo {
    protected int dato;
    protected String datoStr;   // atributo String para que el Nodo sea de 2 tipos de datos
    protected Nodo prev, sig;

    public Nodo(){
        // ..
    }
    public Nodo(int valor){     // ENTERO
        this.dato = valor;
    }
    public Nodo(String valor){  // STRING
        this.datoStr = valor;
    }
    public Nodo(Nodo prev, String valor) {      // ENTERO
        // directamente se enlaza los nodos al instanciarlo
        this.prev = prev;
        this.datoStr = valor;
    }

    public Nodo(Nodo prev, int valor) {         // STRING
        // directamente se enlaza los nodos al instanciarlo
        this.prev = prev;
        this.dato = valor;
    }

    public Nodo(String valor, Nodo sig) {
        // directamente se enlaza los nodos al instanciarlo
        this.datoStr = valor;
        this.sig = sig;
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

        if (prev == null) System.out.print( "-, ");
        else System.out.print(prev.dato + ", ");

        System.out.print(dato + ", ");

        if (sig == null) System.out.print( "-");
        else System.out.print(sig.dato);

        System.out.println();
    }

    public String getDatoStr() {
        return datoStr;
    }
}