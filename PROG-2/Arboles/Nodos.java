package Arboles;

public class Nodos {
    // ..
}



class NodoBinInt {      // NODO BINARIO 'INT'

    NodoBinInt nodoIzq;
    int data;
    NodoBinInt nodoDer;

    public NodoBinInt(){
        // ...
    }
    public NodoBinInt(int valor){
        // asigna solo el valor
        data = valor;
    }

    public NodoBinInt(NodoBinInt nodoIzq, int valor){
        // asigna Nodo IZQ y valor
        this.nodoIzq = nodoIzq;
        data = valor;
    }

    public NodoBinInt(int valor, NodoBinInt nodoDer){
        // asigna valor y Nodo DER
        data = valor;
        this.nodoDer = nodoDer;
    }

    public NodoBinInt(NodoBinInt nodoIzq, int valor, NodoBinInt nodoDer){
        // asigna todos los valores
        this.nodoIzq = nodoIzq;
        data = valor;
        this.nodoDer = nodoDer;
    }
}



class NodoBinStr {      // NODO BINARIO 'STRING'

    NodoBinStr nodoIzq;
    String data;
    NodoBinStr nodoDer;

    public NodoBinStr(){
        // ...
    }
    public NodoBinStr(String valor){
        // asigna solo el valor
        data = valor;
    }

    public NodoBinStr(NodoBinStr nodoIzq, String valor){
        // asigna Nodo IZQ y valor
        this.nodoIzq = nodoIzq;
        data = valor;
    }

    public NodoBinStr(String valor, NodoBinStr nodoDer){
        // asigna valor y Nodo DER
        data = valor;
        this.nodoDer = nodoDer;
    }

    public NodoBinStr(NodoBinStr nodoIzq, String valor, NodoBinStr nodoDer){
        // asigna todos los valores
        this.nodoIzq = nodoIzq;
        data = valor;
        this.nodoDer = nodoDer;
    }
}