/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_actividad5;

import java.util.Scanner;

/**
 *
 * @author Noriega
 */
public class ED_actividad5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        ListaDinamica<Integer> listaaux = new ListaDinamica<>();
        ListaDinamica<Integer> lista2 = new ListaDinamica<>();
        ListaDinamica<Integer> lista3 = new ListaDinamica<>();
        int op, aux;

        do {
            System.out.println("MENU");
            System.out.println("1.- Insertar un elemneto");
            System.out.println("2.- Borrar un elemento");
            System.out.println("3.- Mostrar los elementos de la lista");
            System.out.println("4.- Invertir una lista");
            System.out.println("5.- Crear una segunda lista");
            System.out.println("6.- Concatenar listas");
            System.out.println("7.- Salir");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    int op2 = 0;
                    System.out.println("\nINSERTAR");
                    System.out.println("1.- Al inicio de la lista");
                    System.out.println("2.- Al final de la lista");
                    System.out.println("3.- A la derecha de elemento con info X");
                    System.out.println("4.- A la izquierda de elemento con info X");
                    System.out.println("5.- En la i-esima posicion");
                    System.out.println("6.- De forma ordenada ascendente");
                    op2 = sc.nextInt();
                    switch (op2) {
                        case 1:
                            System.out.println("\nIngrese elemento");
                            op = sc.nextInt();
                            lista.agregaPrim(op);
                            break;
                        case 2:
                            System.out.println("\nIngrese elemento");
                            op = sc.nextInt();
                            lista.agregaUlt(op);
                            break;
                        case 3:
                            System.out.println("\nIngrese elemento a buscar");
                            op = sc.nextInt();
                            aux = lista.posElem(op);
                            System.out.println("ingrese el nuevo elemento");
                            op = sc.nextInt();
                            lista.agrega(op, aux + 1);
                            break;
                        case 4:
                            System.out.println("\nIngrese elemento a buscar");
                            op = sc.nextInt();
                            aux = lista.posElem(op);
                            System.out.println("ingrese el nuevo elemento");
                            op = sc.nextInt();
                            lista.agrega(op, aux);
                            break;
                        case 5:
                            System.out.println("Ingrese posicion del nuevo elemento:");
                            op = sc.nextInt();
                            System.out.println("Ingrese el nuevo elemento");
                            aux = sc.nextInt();
                            lista.agrega(aux, op);
                            break;
                        case 6:
                            int cont = 0,
                             i,
                             menor,
                             mayor = 0;
                            aux = 0;
                            System.out.println("ingrese un lemento");
                            op = sc.nextInt();
                            if (lista.isEmpty() == true) {
                                lista.agregaPrim(op);
                            } else {
                                cont = lista.size();
                                for (i = 0; i < cont; i++) {
                                    menor = lista.get(i);
                                    if (op > menor) {
                                        mayor = lista.get(i);
                                    }
                                }
                                aux = lista.posElem(mayor);
                                lista.agrega(op, aux + 1);

                            }

                            break;
                    }
                    break;

                case 2:

                    System.out.println("\nELIMINAR");
                    System.out.println("1.- Al inicio de la lista");
                    System.out.println("2.- Al final de la lista");
                    System.out.println("3.- A la derecha de elemento con info X");
                    System.out.println("4.- A la izquierda de elemento con info X");
                    System.out.println("5.- El de la i-esima posicion");
                    System.out.println("6.- Con informacion X");
                    System.out.println("7.- Todos los elementos con info X");
                    op2 = sc.nextInt();
                    switch (op2) {
                        case 1:
                            lista.eliminaPrim();
                            System.out.println("Se elimino correctamente\n");
                            break;
                        case 2:
                            lista.eliminaUlt();
                            break;
                        case 3:
                            System.out.println("Ingrese elemento a buscar");
                            op = sc.nextInt();
                            aux = lista.posElem(op);
                            lista.eliminaPos(aux + 1);
                            System.out.println("Eliminado correctamente\n");
                            break;
                        case 4:
                            System.out.println("Ingrese elemento a buscar");
                            op = sc.nextInt();
                            aux = lista.posElem(op);
                            lista.eliminaPos(aux - 1);
                            System.out.println("Eliminado correctamente\n");
                            break;
                        case 5:
                            System.out.println("Ingrese la posicion a borrar");
                            op = sc.nextInt();
                            lista.eliminaPos(op);
                            System.out.println("Eliminado correctamente\n");
                            break;
                        case 6:
                            System.out.println("Ingrese elemento a eliminar");
                            op = sc.nextInt();
                            aux = lista.posElem(op);
                            lista.eliminaPos(aux);
                            System.out.println("Eliminado correctamente\n");
                            break;
                        case 7:
                            aux = 0;
                            System.out.println("Ingrese elemento a eliminar");
                            op = sc.nextInt();
                            while (aux <= lista.size()) {
                                int aux2 = lista.posElem(op);
                                lista.eliminaPos(aux2);
                                aux++;
                            }
                            System.out.println("Eliminado correctamente\n");
                            break;
                    }
                    break;

                case 3:

                    System.out.println("Los elementos ingresados son: ");
                    System.out.println(lista.toString());

                    break;

                case 4:
                    int cont = lista.size();
                    for (int i = 0; i < cont; i++) {
                        aux = listaaux.getUltimo();
                        listaaux.agregaUlt(aux);
                        lista.eliminaUlt();
                    }
                    System.out.println("La lista invertida es:");
                    System.out.println(listaaux.toString());
                    break;
                case 5:
                    System.out.println("IMPORTANTE: Solo se insertaran elemento al final de esta lista");
                    System.out.println("Ingrese elemento");
                    op = sc.nextInt();
                    lista2.agregaUlt(op);
                    break;
                case 6:
                    int i,
                     menor = 0,
                     mayor = 0,
                     aux2;
                    aux = 0;
                    cont = 0;
                    if (lista.isEmpty() == true && lista2.isEmpty() == true) {
                        System.out.println("Aun no existe ninguna lista");
                    } else if (lista.isEmpty() == false && lista2.isEmpty() == true) {
                        System.out.println("La lista 2 aun no existe");
                    } else {

                        System.out.println("Las listas concatenadas de forma ascendente es:");
                        System.out.println(lista3.toString());

                    }

                    break;
            }
        } while (op != 7);

    }
}
