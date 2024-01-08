package es.ull.patrones.practica7.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ISeguimientoVuelo extends JFrame {

    private JComboBox<String> opcionesComboBox;
    private JTextField cuadroTexto;
    private JButton botonAccion;

    public ISeguimientoVuelo() {
        // Configuración de la ventana
        setTitle("Ventana de Selección");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));

        // Crear el JComboBox con las opciones
        String[] opciones = {"Matrícula", "ID", "Vuelo"};
        opcionesComboBox = new JComboBox<>(opciones);

        // Crear el JTextField
        cuadroTexto = new JTextField();

        // Crear el JButton para realizar alguna acción
        botonAccion = new JButton("Continuar");

        // Configurar el ActionListener para el botón
        botonAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) opcionesComboBox.getSelectedItem();
                String textoIngresado = cuadroTexto.getText();

                // Realizar alguna acción según la opción seleccionada
                // Puedes agregar aquí el código correspondiente a la acción que deseas realizar
                // Por ejemplo, imprimir en la consola la opción seleccionada y el texto ingresado
                System.out.println("Opción seleccionada: " + opcionSeleccionada);
                System.out.println("Texto ingresado: " + textoIngresado);
            }
        });

        // Agregar componentes al panel principal
        panelPrincipal.add(opcionesComboBox);
        panelPrincipal.add(cuadroTexto);
        panelPrincipal.add(botonAccion);

        // Agregar el panel principal al contenedor de la ventana
        getContentPane().add(panelPrincipal);

        // Hacer visible la ventana
        setVisible(true);
    }


}


