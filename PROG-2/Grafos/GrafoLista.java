package Grafos;

/*
    PROGRAMA DE LAUTARO SANCHEZ - 19/11/23

*/

public class GrafoLista {
    List[] listaAdyacencia;
    String[] vertices;

    public GrafoLista(String[] vertices) {
        this.vertices = vertices;
        listaAdyacencia = new List[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            listaAdyacencia[i] = new List(new Node(vertices[i]));
        }
    }

    public void conectar(String v1, String v2) {
        int indiceV1 = buscarIndice(v1);
        int indiceV2 = buscarIndice(v2);

        if (indiceV1 != -1 && indiceV2 != -1) {
            listaAdyacencia[indiceV1].agregarAlFinal(new Node(v2));
            listaAdyacencia[indiceV2].agregarAlFinal(new Node(v1));
        } else {
            System.out.println("Uno o ambos vértices no existen en el grafo.");
        }
    }

    private int buscarIndice(String vertice) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }

    public void imprimir() {
        for (int i = 0; i < listaAdyacencia.length; i++) {
            System.out.print(vertices[i] + " está conectado con: ");
            listaAdyacencia[i].imprimirLista();
            System.out.println();
        }
    }
    public boolean sonAdyacentes(String v1, String v2) {
        int indiceV1 = buscarIndice(v1);
        int indiceV2 = buscarIndice(v2);

        if (indiceV1 != -1 && indiceV2 != -1) {
            Node temp = listaAdyacencia[indiceV1].cabeza.siguiente;
            while (temp != null) {
                if (temp.valor.equals(v2)) {
                    return true;
                }
                temp = temp.siguiente;
            }
        }
        return false;
    }
    public void eliminarAdyacencia(String v1, String v2) {
        int indiceV1 = buscarIndice(v1);
        int indiceV2 = buscarIndice(v2);

        if (indiceV1 != -1 && indiceV2 != -1) {
            listaAdyacencia[indiceV1].eliminarNodo(v2);
            listaAdyacencia[indiceV2].eliminarNodo(v1);
        } else {
            System.out.println("Uno o ambos vértices no existen en el grafo.");
        }
    }
    public void recorrerNodos() {
        for (int i = 0; i < listaAdyacencia.length; i++) {
            System.out.print(vertices[i] + " está conectado con: ");
            listaAdyacencia[i].imprimirLista();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] vertices = {"A", "B", "C", "D"};
        GrafoLista grafo = new GrafoLista(vertices);

        grafo.conectar("A", "B");
        grafo.conectar("A", "C");
        grafo.conectar("B", "C");
        grafo.conectar("C", "D");

        grafo.imprimir();
    }
}

class List {
    Node cabeza;

    public List(Node cabeza) {
        this.cabeza = cabeza;
    }

    public void agregarAlFinal(Node nodo) {
        Node temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nodo;
    }

    public void imprimirLista() {
        Node temp = cabeza.siguiente;
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
    }

    public void eliminarNodo(String valor) {
        Node temp = cabeza;
        Node prev = null;

        if (temp != null && temp.valor.equals(valor)) {
            cabeza = temp.siguiente;
            return;
        }

        while (temp != null && !temp.valor.equals(valor)) {
            prev = temp;
            temp = temp.siguiente;
        }

        if (temp == null) {
            return;
        }

        prev.siguiente = temp.siguiente;
    }


}

class Node {
    String valor;
    Node siguiente;

    public Node(String valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}