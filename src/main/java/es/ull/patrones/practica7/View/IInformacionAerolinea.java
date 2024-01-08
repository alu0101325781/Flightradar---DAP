package es.ull.patrones.practica7.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IInformacionAerolinea extends JFrame {

    private JTextField campoAerolinea;
    private JButton botonConsultar;
    private JButton botonVolver;
    private JLabel imagenAerolinea; // Nuevo JLabel para mostrar la imagen

    public IInformacionAerolinea(String nombre_aerolinea) {
        // Configuración de la ventana
        setTitle("Información de Aerolínea");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1));

        // Crear el JTextField
        campoAerolinea = new JTextField();
        botonConsultar = new JButton("Consultar");
        botonVolver = new JButton("Volver al Menú");
        imagenAerolinea = new JLabel(); // Nuevo JLabel para mostrar la imagen

        // Configurar el ActionListener para el botón de Consultar
        botonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAerolinea = campoAerolinea.getText();

                System.out.println(nombre_aerolinea);
                cargarImagenAerolinea(nombreAerolinea);
            }
        });

        // Configurar el ActionListener para el botón de Volver al Menú
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();
            }
        });

        // Agregar componentes al panel principal
        panelPrincipal.add(new JLabel("Nombre de la Aerolínea:"));
        panelPrincipal.add(campoAerolinea);
        panelPrincipal.add(botonConsultar);
        panelPrincipal.add(botonVolver);
        panelPrincipal.add(imagenAerolinea); // Agregar el JLabel al panel

        // Agregar el panel principal al contenedor de la ventana
        getContentPane().add(panelPrincipal);

        // Hacer visible la ventana
        setVisible(true);
    }

    // Método para cargar la imagen de la aerolínea
    private void cargarImagenAerolinea(String nombreAerolinea) {
        // Aquí debes implementar la lógica para cargar la imagen según el nombre de la aerolínea
        // Por ahora, simplemente estableceremos una imagen de ejemplo
        String nombreArchivoImagen = obtenerNombreImagen(nombreAerolinea);
        ImageIcon icono = new ImageIcon(nombreArchivoImagen);
        imagenAerolinea.setIcon(icono);
    }

    // Método de ejemplo para obtener el nombre del archivo de imagen según el nombre de la aerolínea
    private String obtenerNombreImagen(String nombreAerolinea) {
        // En un caso real, deberías tener una lógica para mapear el nombre de la aerolínea a un archivo de imagen específico
        // Este es solo un ejemplo, y debes personalizarlo según tus necesidades
        switch (nombreAerolinea.toLowerCase()) {
            case "aerolinea1":
                return "aerolinea1.jpg";
            case "aerolinea2":
                return "aerolinea2.jpg";
            // Agrega más casos según sea necesario
            default:
                return "imagen_predeterminada.jpg";
        }
    }
}

