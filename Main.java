import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        // Ruta al archivo JSON
        String filePath = "/home/enrique/IdeaProjects/Flightradar---DAP/Flightradar---DAP/airport_fields.json";

        // Crear el sujeto observado
        FlightTracker flightTracker = new FlightTracker(filePath);

        // Crear observadores
        FlightInfoSubscriber subscriber1 = new FlightInfoSubscriber("Observador 1", flightTracker);

        // Registrar observadores con el sujeto
        flightTracker.registerObserver(subscriber1);

        // Crear la interfaz de usuario y registrarla como observadora
        FlightInfoUI flightInfoUI = new FlightInfoUI(flightTracker);

        // Mostrar la interfaz de usuario
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                flightInfoUI.setVisible(true);
            }
        });
    }
}


