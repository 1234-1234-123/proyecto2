/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editortexto2;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// clase que se encarga de buscar y resaltar palabras en un textarea
public class Buscador {
    private JTextArea areaTexto; // area de texto donde se hace la busqueda
    private String texto; // texto completo del area
    private String palabraBuscar; // palabra que se quiere buscar
    private List<Integer> posiciones; // lista de posiciones donde aparece la palabra
    private int indiceActual; // indice de la ocurrencia actual

    // constructor que recibe el textarea
    public Buscador(JTextArea areaTexto) {
        this.areaTexto = areaTexto; // se guarda el area de texto
        this.posiciones = new ArrayList<>(); // inicializa la lista vacia
        this.indiceActual = -1; // empieza sin ninguna palabra seleccionada
    }

    // metodo para buscar y resaltar una palabra
    public void buscarYResaltar(String palabra) {
        this.palabraBuscar = palabra; // guarda la palabra que se quiere buscar
        this.texto = areaTexto.getText(); // obtiene el texto del area
        this.posiciones.clear(); // limpia las posiciones anteriores
        this.indiceActual = -1; // reinicia el indice actual

        Highlighter highlighter = areaTexto.getHighlighter(); // obtiene el resaltador del area
        highlighter.removeAllHighlights(); // borra los resaltados anteriores

        // busca todas las ocurrencias de la palabra
        int posicion = 0;
        while ((posicion = texto.indexOf(palabra, posicion)) >= 0) {
            posiciones.add(posicion); // guarda la posicion donde se encontro
            posicion += palabra.length(); // avanza al final de la palabra encontrada
        }

        resaltarOcurrencias(); // resalta todas las palabras encontradas
        if (tieneOcurrencias()) {
            irASiguienteOcurrencia(); // va a la primera ocurrencia
        }
    }

    // metodo para resaltar las ocurrencias encontradas
    private void resaltarOcurrencias() {
        Highlighter highlighter = areaTexto.getHighlighter(); // obtiene el resaltador
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink); // define el color rosado

        for (int posicion : posiciones) {
            try {
                // resalta desde la posicion hasta el final de la palabra
                highlighter.addHighlight(posicion, posicion + palabraBuscar.length(), painter);
            } catch (BadLocationException e) {
                e.printStackTrace(); // muestra el error si ocurre
            }
        }
    }

    // devuelve true si se encontraron palabras
    public boolean tieneOcurrencias() {
        return !posiciones.isEmpty();
    }

    // mueve el cursor a la siguiente ocurrencia
    public void irASiguienteOcurrencia() {
        if (!tieneOcurrencias()) return;

        indiceActual = (indiceActual + 1) % posiciones.size(); // avanza al siguiente indice
        int posicion = posiciones.get(indiceActual); // obtiene la posicion actual
        areaTexto.setCaretPosition(posicion); // mueve el cursor
        areaTexto.requestFocusInWindow(); // da enfoque al textarea
    }
}


