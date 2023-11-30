package PatronObservador;

import javax.swing.*;
import java.awt.*;

class ConcreteListener implements EventListener {
    private String name;
    private Ventana ventana;  // Agrega una referencia a la ventana

    public ConcreteListener(String name, Ventana ventana) {
        this.name = name;
        this.ventana = ventana;  // Inicializa la referencia a la ventana
    }

    @Override
    public void update(String flightInfo) {
        // Llama al método mostrarMensaje de la ventana
        SwingUtilities.invokeLater(() -> ventana.mostrarMensaje("Se detectó un cambio en el .json"));
    }
}
