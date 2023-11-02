package Arboles;

public class ArbolBinINT {
    NodoBinInt raiz;

    public ArbolBinINT(){
        raiz = null;
    }

    public ArbolBinINT(NodoBinInt raiz){
        // instancia el arbol con una raiz especifica
        this.raiz = raiz;
    }

    public static void main(String[] args) {
        ArbolBinINT arbolBin = new ArbolBinINT();

        // carga de valores
        arbolBin.agregar(4);
        arbolBin.agregar(2);
        arbolBin.agregar(3);
        arbolBin.agregar(1);
        arbolBin.agregar(5);
        arbolBin.agregar(6);

        arbolBin.imprPostOrd(arbolBin.raiz);
    }

    public void agregar(int valor){
        this.raiz = agregarRecursiv(this.raiz, valor);  // la raiz pq tiene que comparar con ese
    }

    private NodoBinInt agregarRecursiv(NodoBinInt nodoVerif, int valor){
        // Si el nodo es una hoja, entonces lo crear y retorna
        if (nodoVerif == null){
            nodoVerif = new NodoBinInt(valor);
            return nodoVerif;
        }

        // En caso contrario, recorrer el arbol de forma recursiva
        if (valor < nodoVerif.data ) {
            nodoVerif.nodoIzq = agregarRecursiv(nodoVerif.nodoIzq, valor);    // recursivo
        }

        else if (valor >= nodoVerif.data) {
            nodoVerif.nodoDer = agregarRecursiv(nodoVerif.nodoDer, valor);    // recursivo
        }
        return nodoVerif;
    }

    public void imprPreOrd(NodoBinInt nodo){  // pre-orden
        /*if (this.raiz == null) {
            System.out.printf("Vacío.");
            return;
        }*/
        System.out.print(nodo.data + ", ");
        if (nodo.nodoIzq != null){
            imprPreOrd(nodo.nodoIzq);
        }
        if (nodo.nodoDer != null){
            imprPreOrd(nodo.nodoDer);
        }
    }

    public void imprInOrd(NodoBinInt nodo){    // in-orden
        if (nodo.nodoIzq != null){
            imprInOrd(nodo.nodoIzq);
        }
        System.out.print(nodo.data + ", ");
        if (nodo.nodoDer != null){
            imprInOrd(nodo.nodoDer);
        }
    }
    public void imprPostOrd(NodoBinInt nodo){   // post-orden
        if (nodo.nodoIzq != null){
            imprPostOrd(nodo.nodoIzq);
        }
        if (nodo.nodoDer != null){
            imprPostOrd(nodo.nodoDer);
        }
        System.out.print(nodo.data + ", ");
    }
}
