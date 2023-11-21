package Nodos;

import java.util.Scanner;

public class ListaNodosMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();


        lista.agregarFinal(2);  // para ir probando
        lista.agregarFinal(4);
        lista.agregarFinal(6);
        lista.agregarFinal(8);
        lista.agregarFinal(10);

        lista.imprimirLista();
        lista.invertirLista();
        lista.imprimirLista();

        while (true) {
            System.out.println("-------------------------------");
            System.out.print(" 1- Agregar al Inicio\n 2- Imprimir Lista ("+lista.getLength() + ")" +
                    "\n 3- Agregar al Final\n 4- Ultimo Elemento\n" +
                    " 5- Existe Valor\n 6- Eliminar posición\n" +
                    " 7- Agregar en posición\n 8- Modificar posición\n 9- SALIR\n --> ");
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
                    if (lista.getUltNodo() == null) System.out.println("--");
                    else System.out.println(lista.getUltNodo().dato);
                    break;

                case 5:
                    if (lista.getPrimerNodo() == null){    // verifica que la lista no esté vacia
                        System.out.println("\t\tLista vacía");
                        break;
                    }
                    System.out.print("Valor a buscar: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.existeValor(valor);
                    break;
                case 6:
                    if (lista.getPrimerNodo() == null){    // verifica que la lista no esté vacia
                        System.out.println("\t\tLista vacía");
                        break;
                    }
                    System.out.print("Eliminar posición: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.eliminarElem(valor);
                    break;

                case 7:
                    System.out.print("Posición: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Valor: ");
                    int valor2 = sc.nextInt();
                    sc.nextLine();
                    lista.agregarMedio(valor, valor2);
                    break;

                case 8:
                    System.out.print("Posición: ");
                    valor = sc.nextInt();
                    sc.nextLine();
                    lista.modifPosicion(valor, sc);
                    break;

                case 9:
                    System.exit(0);
                    break;
            }
        }
    }
}


