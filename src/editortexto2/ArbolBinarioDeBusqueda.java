/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editortexto2;


import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioDeBusqueda {
    private Nodo raiz; 

    // metodo para insertar una palabra con su posicion en el arbol
    public void insertar(String palabra, int posicion) {
        raiz = insertarRec(raiz, palabra, posicion); // aca inicia la isercion recursiva desde la raiz
    }

    // metodo para insercion de nodos
    private Nodo insertarRec(Nodo nodo, String palabra, int posicion) {
        // si llegamos a un nodo nulo, creamos un nuevo nodo con la palabra y posicion
        if (nodo == null) {
            return new Nodo(palabra, posicion);
        }

        // comparacion para determinar en que subarbol continua
       int comparacion = palabra.compareTo(nodo.palabra);
        
        if (comparacion < 0) {  // si la palabra es menor, vamos al subarbol izquierdo
            nodo.izquierda = insertarRec(nodo.izquierda, palabra, posicion);
        } else if (comparacion > 0) {  // si la palabra es mayor, vamos al subarbol derecho
            nodo.derecha = insertarRec(nodo.derecha, palabra, posicion);
        } else {  // si la palabra ya existe, agregamos la posicion a la lista existente
            nodo.posiciones.add(posicion);
        }
        return nodo;  // retornamos el nodo actual para reconstruir la estructura del arbol
    }

    // metodo publico para buscar las posiciones de una palabra
    public List<Integer> buscarPosiciones(String palabraBuscar) {
        return buscarRec(raiz, palabraBuscar);  // inicia la busqueda recursiva desde la raiz
    }

    // metodo recursivo para busqueda de palabras
    private List<Integer> buscarRec(Nodo nodo, String palabraBuscar) {
        // si llegamos a un nodo nulo, retornamos lista vacia
        if (nodo == null) return new ArrayList<>();

        int comparacion = palabraBuscar.compareTo(nodo.palabra);
        
        if (comparacion == 0) {  // palabra encontrada, retornamos sus posiciones
            return nodo.posiciones;
        } else if (comparacion < 0) {  // buscamos en el subarbol izquierdo
            return buscarRec(nodo.izquierda, palabraBuscar);
        } else {  // buscamos en el subarbol derecho
            return buscarRec(nodo.derecha, palabraBuscar);
        }
    }
}
