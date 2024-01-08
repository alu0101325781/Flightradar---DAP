package es.ull.patrones.practica7.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    // Variables para almacenar texto ingresado
    private String matriculaIngresada;
    private String nombreAerolineaIngresado;
    private String codigoAeropuertoIngresado;

    public MenuUI() {
        // Configuración del JFrame
        setTitle("Menú Principal");
        setSize(400, 150);  // Tamaño ajustado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un JPanel con CardLayout para cambiar entre diferentes paneles
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Crear los diferentes paneles (inicialmente vacíos)
        JPanel emptyPanel = new JPanel();
        JPanel seguimientoPanel = new JPanel();
        JPanel historialPanel = new JPanel();
        JPanel aerolineaPanel = new JPanel();
        JPanel aeropuertoPanel = new JPanel();

        cardPanel.add(emptyPanel, "empty");
        cardPanel.add(seguimientoPanel, "seguimiento");
        cardPanel.add(historialPanel, "historial");
        cardPanel.add(aerolineaPanel, "aerolinea");
        cardPanel.add(aeropuertoPanel, "aeropuerto");

        // Agregar el panel con CardLayout al JFrame
        getContentPane().add(cardPanel);

        // Crear botones con tamaño ajustado
        JButton btnSeguimiento = new JButton("Seguimiento de vuelo");
        JButton btnHistorial = new JButton("Historial de un avión");
        JButton btnAerolinea = new JButton("Información Aerolínea");
        JButton btnAeropuerto = new JButton("Información de Aeropuerto");

        // Cambiar el tamaño de los botones
        Dimension btnSize = new Dimension(180, 50);
        btnSeguimiento.setPreferredSize(btnSize);
        btnHistorial.setPreferredSize(btnSize);
        btnAerolinea.setPreferredSize(btnSize);
        btnAeropuerto.setPreferredSize(btnSize);

        // Agregar ActionListener a cada botón
        btnSeguimiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ISeguimientoVuelo();
            }
        });

        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo panel "Matrícula" y un cuadro de texto
                JPanel matriculaPanel = new JPanel();
                JLabel etiquetaMatricula = new JLabel("Matrícula:");
                JTextField campoMatricula = new JTextField(10);
                JButton botonConsultar = new JButton("Consultar");
                JButton botonVolver = new JButton("Volver al Menú");

                // Configurar el ActionListener para el botón de Consultar
                botonConsultar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Asignar el texto ingresado a la variable
                        matriculaIngresada = campoMatricula.getText();

                        // Realizar alguna acción según la matrícula ingresada
                        System.out.println("Matrícula ingresada: " + matriculaIngresada);
                    }
                });

                // Configurar el ActionListener para el botón de Volver al Menú
                botonVolver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Volver al panel inicial (Menú)
                        cardLayout.show(cardPanel, "empty");
                    }
                });

                // Agregar componentes al panel "Matrícula"
                matriculaPanel.add(etiquetaMatricula);
                matriculaPanel.add(campoMatricula);
                matriculaPanel.add(botonConsultar);
                matriculaPanel.add(botonVolver);

                // Mostrar el panel "Matrícula" en el cardPanel
                cardPanel.add(matriculaPanel, "matricula");
                cardLayout.show(cardPanel, "matricula");
            }
        });

        btnAerolinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo panel "Aerolínea" y un cuadro de texto
                JPanel aerolineaPanel = new JPanel();
                JLabel etiquetaAerolinea = new JLabel("Nombre de la Aerolínea:");
                JTextField campoAerolinea = new JTextField(10);
                JButton botonConsultar = new JButton("Consultar");
                JButton botonVolver = new JButton("Volver al Menú");

                // Configurar el ActionListener para el botón de Consultar
                botonConsultar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Asignar el texto ingresado a la variable
                        nombreAerolineaIngresado = campoAerolinea.getText();

                        // Realizar alguna acción según el nombre de la aerolínea ingresado
                        System.out.println("Nombre de la Aerolínea ingresado: " + nombreAerolineaIngresado);
                    }
                });

                // Configurar el ActionListener para el botón de Volver al Menú
                botonVolver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Volver al panel inicial (Menú)
                        cardLayout.show(cardPanel, "empty");
                    }
                });

                // Agregar componentes al panel "Aerolínea"
                aerolineaPanel.add(etiquetaAerolinea);
                aerolineaPanel.add(campoAerolinea);
                aerolineaPanel.add(botonConsultar);
                aerolineaPanel.add(botonVolver);

                // Mostrar el panel "Aerolínea" en el cardPanel
                cardPanel.add(aerolineaPanel, "aerolinea");
                cardLayout.show(cardPanel, "aerolinea");
            }
        });

        btnAeropuerto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo panel "Aeropuerto" y un cuadro de texto
                JPanel aeropuertoPanel = new JPanel();
                JLabel etiquetaAeropuerto = new JLabel("Código de Aeropuerto:");
                JTextField campoAeropuerto = new JTextField(10);
                JButton botonConsultar = new JButton("Consultar");
                JButton botonVolver = new JButton("Volver al Menú");

                // Configurar el ActionListener para el botón de Consultar
                botonConsultar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Asignar el texto ingresado a la variable
                        codigoAeropuertoIngresado = campoAeropuerto.getText();

                        // Realizar alguna acción según el código de aeropuerto ingresado
                        System.out.println("Código de Aeropuerto ingresado: " + codigoAeropuertoIngresado);
                    }
                });

                // Configurar el ActionListener para el botón de Volver al Menú
                botonVolver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Volver al panel inicial (Menú)
                        cardLayout.show(cardPanel, "empty");
                    }
                });

                // Agregar componentes al panel "Aeropuerto"
                aeropuertoPanel.add(etiquetaAeropuerto);
                aeropuertoPanel.add(campoAeropuerto);
                aeropuertoPanel.add(botonConsultar);
                aeropuertoPanel.add(botonVolver);

                // Mostrar el panel "Aeropuerto" en el cardPanel
                cardPanel.add(aeropuertoPanel, "aeropuerto");
                cardLayout.show(cardPanel, "aeropuerto");
            }
        });

        // Agregar botones al panel inicial
        emptyPanel.add(btnSeguimiento);
        emptyPanel.add(btnHistorial);
        emptyPanel.add(btnAerolinea);
        emptyPanel.add(btnAeropuerto);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuUI();
            }
        });
    }
}
