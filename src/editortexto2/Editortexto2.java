/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package editortexto2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// clase principal del editor de texto
public class Editortexto2 extends JFrame {
    private JTextArea areaTexto; // area donde se escribe el texto
    private JButton btnDeshacer, btnRehacer, btnBuscar; // botones para deshacer, rehacer y buscar
    private GestorOperaciones gestorOperaciones; // clase que maneja los cambios de texto
    private Buscador buscador; // clase que busca palabras
    private String palabraBuscar; // palabra que se quiere buscar

    // constructor
    public Editortexto2() {
        setTitle("EDITOR DE TEXTO"); // titulo de la ventana
        setSize(800, 600); // tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar la app al cerrar la ventana

        areaTexto = new JTextArea(); // se crea el textarea
        JScrollPane scrollPane = new JScrollPane(areaTexto); // se le agrega scroll

        gestorOperaciones = new GestorOperaciones(); // instancia el gestor de cambios
        buscador = new Buscador(areaTexto); // se pasa el textarea al buscador

        btnDeshacer = new JButton("DESHACER"); // boton para deshacer
        btnRehacer = new JButton("REHACER"); // boton para rehacer
        btnBuscar = new JButton("BUSCAR"); // boton para buscar

        JPanel panelBotones = new JPanel(); // panel para colocar los botones
        panelBotones.add(btnDeshacer); // se agrega el boton deshacer
        panelBotones.add(btnRehacer); // se agrega el boton rehacer
        panelBotones.add(btnBuscar); // se agrega el boton buscar

        add(scrollPane, BorderLayout.CENTER); // se pone el scroll en el centro
        add(panelBotones, BorderLayout.SOUTH); // se ponen los botones abajo

        configurarEventos(); // metodo que configura lo que hacen los botones y teclas

        setVisible(true); // muestra la ventana
    }

    // metodo que configura los eventos de los botones y teclado
    private void configurarEventos() {
        // evento del boton buscar
        btnBuscar.addActionListener(e -> {
            palabraBuscar = JOptionPane.showInputDialog(
                this,
                "Ingrese la palabra a buscar:", // mensaje para el usuario
                "Busqueda", // titulo de la ventana emergente
                JOptionPane.QUESTION_MESSAGE // tipo de mensaje
            );

            if (palabraBuscar != null && !palabraBuscar.isEmpty()) {
                buscador.buscarYResaltar(palabraBuscar); // llama al buscador
            }
        });

        // evento del boton deshacer
        btnDeshacer.addActionListener(e -> {
            String textoAnterior = gestorOperaciones.deshacer(); // obtiene el texto anterior
            areaTexto.setText(textoAnterior); // lo muestra en el textarea
        });

        // evento del boton rehacer
        btnRehacer.addActionListener(e -> {
            String textoNuevo = gestorOperaciones.rehacer(); // obtiene el texto rehecho
            areaTexto.setText(textoNuevo); // lo muestra en el textarea
        });

        // evento cuando se suelta una tecla
        areaTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // si se presiona espacio, punto o coma, se guarda el estado
                if (e.getKeyCode() == KeyEvent.VK_SPACE ||
                    e.getKeyChar() == '.' ||
                    e.getKeyChar() == ',') {
                    gestorOperaciones.guardarEstado(areaTexto.getText()); // guarda el texto actual
                }
            }
        });
    }

    // metodo principal para ejecutar la aplicacion
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Editortexto2::new); // inicia la aplicacion de forma segura
    }
}

