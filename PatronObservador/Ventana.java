package PatronObservador;

import javax.swing.*;



import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ventana extends JFrame {
    private JLabel label;

    private String nombreUsuario;  // Agrega una variable para almacenar el nombre del usuario

    public Ventana(String nombreUsuario) {
        super(nombreUsuario);  // Usa el nombre del usuario en el título
        this.nombreUsuario = nombreUsuario;
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        label = new JLabel("Esperando cambios...");
        add(label, BorderLayout.CENTER);
    }

    public void mostrarMensaje(String mensaje) {
        label.setText(mensaje);
    }
}