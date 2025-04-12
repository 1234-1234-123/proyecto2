/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editortexto2;
import java.util.Stack; // importa pilas para guardar los cambios del texto

// clase que maneja deshacer y rehacer
public class GestorOperaciones {
    private Stack<String> pilaDeshacer; // pila que guarda los textos anteriores
    private Stack<String> pilaRehacer; // pila que guarda los textos deshechos
    private String textoActual; // texto que esta actualmente en el textarea

    // constructor que inicializa todo
    public GestorOperaciones() {
        pilaDeshacer = new Stack<>(); // crea la pila de deshacer
        pilaRehacer = new Stack<>(); // crea la pila de rehacer
        textoActual = ""; // comienza con texto vacio
    }

    // metodo para guardar un nuevo estado
    public void guardarEstado(String nuevoTexto) {
        if (!textoActual.equals(nuevoTexto)) { // solo guarda si hay cambios
            pilaDeshacer.push(textoActual); // guarda el texto actual en la pila de deshacer
            textoActual = nuevoTexto; // actualiza el texto actual
            pilaRehacer.clear(); // limpia la pila de rehacer
        }
    }

    // metodo para deshacer el ultimo cambio
    public String deshacer() {
        if (!pilaDeshacer.isEmpty()) { // si hay texto para deshacer
            pilaRehacer.push(textoActual); // guarda el actual en rehacer
            textoActual = pilaDeshacer.pop(); // toma el ultimo guardado
            return textoActual; // devuelve el texto
        }
        return textoActual; // si no hay nada, devuelve el mismo
    }

    // metodo para rehacer lo que se deshizo
    public String rehacer() {
        if (!pilaRehacer.isEmpty()) { // si hay texto para rehacer
            pilaDeshacer.push(textoActual); // guarda el actual en deshacer
            textoActual = pilaRehacer.pop(); // toma el que se habia deshecho
            return textoActual; // devuelve el texto
        }
        return textoActual; // si no hay nada, devuelve el mismo
    }
}
