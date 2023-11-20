package Arboles;

public class ArbolBinINT {
    NodoBinInt raiz;
    String[] niveles;
    int altura;

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

        //arbolBin.imprPostOrd(arbolBin.raiz);

        arbolBin.returnAltura();    // setea y retorna la altura (cant niveles) del arbol
        arbolBin.imprimirNivel();
    }

    // ===================== EJERCICIO 2 =====================
    // https://www.youtube.com/watch?v=9o7xJfYqWSI&ab_channel=andresflorez

    public void imprimirNivel(){
        niveles  = new String[altura+1];
        imprimirNivel(raiz, 0);

        for (String a : niveles){
            if (a != null)  System.out.print(a);
        }
    }

    private void imprimirNivel(NodoBinInt nodo, int pos) {
        if (nodo != null){
            niveles[pos] = nodo.data + ", "+ ( (niveles[pos] != null) ? niveles[pos] : "" );
            imprimirNivel(nodo.nodoDer, pos+1);
            imprimirNivel(nodo.nodoIzq, pos+1);
        }

    }

    public int returnAltura(){
        // metodo para obtener cantidad de niveles de una arbol binario
        altura = 0;
        returnAltura(raiz, 1);
        return this.altura;
    }

    private void returnAltura(NodoBinInt nodo, int pos){    // recursividad
        if (nodo != null){
            returnAltura(nodo.nodoIzq, pos+1);
            if (pos > altura) {
                altura = pos;
            }
            returnAltura(nodo.nodoDer, pos+1);
        }
    }

    // ===================== FIN EJER 2 =====================


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
