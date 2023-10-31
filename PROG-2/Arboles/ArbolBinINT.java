package Arboles;

public class ArbolBinINT {     //
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


    }

    public NodoBinInt agregarRecursiv(NodoBinInt nodoParm, int valor){
        // Si el nodo es una hoja, entonces lo crear y retorna
        if (nodoParm == null){
            nodoParm = new NodoBinInt(valor);
            return nodoParm;
        }

        // En caso contrario, recorrer el arbol de forma recursiva
        if (nodoParm.data <= 0 ) {
            nodoParm.nodoIzq = agregarRecursiv(nodoParm.nodoIzq, valor);
        }

        else if (nodoParm.data > 0) {
            nodoParm.nodoDer = agregarRecursiv(nodoParm.nodoDer, valor);
        }
        return nodoParm;
    }
}
