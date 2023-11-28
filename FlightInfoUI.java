import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightInfoUI extends JFrame implements IObserver {
    private JTextArea textArea;

    public FlightInfoUI(FlightTracker flightTracker) {
        // Configurar la interfaz de usuario
        setTitle("Flight Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes de la interfaz
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton closeButton = new JButton("Cerrar");

        // Configurar el diseño de la interfaz
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);

        // Agregar un listener al botón de cerrar
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Registrar esta interfaz como observadora del sujeto
        flightTracker.registerObserver(this);
    }

    @Override
    public void update(String flightInfo) {
        // Actualizar el área de texto con la nueva información del vuelo
        textArea.append(flightInfo + "\n");
    }
}
