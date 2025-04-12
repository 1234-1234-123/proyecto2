/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editortexto2;
import java.util.ArrayList;
import java.util.List;

class Nodo {
    String palabra; 
    List<Integer> posiciones; // lista de posiciones
    Nodo izquierda, derecha; // referencias de nodo izquiero, derecho 

    // constructor
    public Nodo(String palabra, int posicion) {
        this.palabra = palabra;
        this.posiciones = new ArrayList<>();
        this.posiciones.add(posicion); // agregar la primera posicion
        this.izquierda = null;
        this.derecha = null;
    }
}
